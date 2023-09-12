package com.apistory.sdk.client;

/**
 * 调用第三方接口的客户端
 */
public class ApiStorySdk {

    private String accessKey;

    private String secretKey;

    public ApiStorySdk(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }
}
