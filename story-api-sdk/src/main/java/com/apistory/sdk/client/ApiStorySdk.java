package com.apistory.sdk.client;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import static com.apistory.sdk.utils.SignUtils.genSign;

/**
 * 调用第三方接口的客户端
 */
public class ApiStorySdk {

    private String accessKey;

    private String secretKey;

    private static final String GATEWAY_HOST = "http://localhost:8090";

    public ApiStorySdk(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    private Map<String, String> getHeader(String num, String body, String method) throws UnsupportedEncodingException {
        HashMap<String, String> map = new HashMap<>();
        map.put("accessKey", accessKey);
        map.put("nonce", num);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("sign", genSign(body, secretKey));
        body = URLUtil.encode(body, CharsetUtil.CHARSET_UTF_8);
        map.put("body", body);
        map.put("method", method);
        return map;
    }

    // TODO 这里应该动态判断传入的method是什么方法，动态去发对应的请求类型！！！
    public String invokeInterface(String num, String params, String url, String method) throws UnsupportedEncodingException {
        HttpRequest httpRequest = null;
        if ("GET".equalsIgnoreCase(method)) {
            httpRequest = HttpRequest.get(GATEWAY_HOST + url)
                    .header("Accept-Charset", CharsetUtil.UTF_8)
                    .addHeaders(getHeader(num, params, method))
                    .body(params);
        } else if ("POST".equalsIgnoreCase(method)) {
            httpRequest = HttpRequest.post(GATEWAY_HOST + url)
                    .header("Accept-Charset", CharsetUtil.UTF_8)
                    .addHeaders(getHeader(num, params, method))
                    .body(params);
        } else {
            throw new IllegalArgumentException("Invalid HTTP method");
        }
        HttpResponse httpResponse = httpRequest.execute();
        return JSONUtil.formatJsonStr(httpResponse.body());
    }


    public String getUsernameByGet(String nonce) {
        String username = "";
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST + "/api/name/get")
                .addHeaders(getHeaderMap(username, nonce))
                .execute();
        return httpResponse.body();
    }

    /**
     * @param username 转入的参数
     * @param nonce    随机数
     * @return String
     */
    public String getUsernameByPost(String username, String nonce) {
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/post")
                .addHeaders(getHeaderMap(username, nonce))
                .execute();
        return httpResponse.body();
    }

    private Map<String, String> getHeaderMap(String body, String nonce) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        hashMap.put("nonce", nonce);
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, secretKey));
        return hashMap;
    }
}
