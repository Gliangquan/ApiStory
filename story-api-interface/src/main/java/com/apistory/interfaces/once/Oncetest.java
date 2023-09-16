package com.apistory.interfaces.once;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

public class Oncetest {

    public static void main(String[] args) {
//        String url = "https://v2.api-m.com/api/baiduhot";
//        HttpResponse httpResponse = HttpRequest.post(url)
//                .execute();
//        System.out.println("httpResponse.body() = " + httpResponse.body());

        String url = "https://v.api.aa1.cn/api/yiyan/index.php";
        HttpResponse httpResponse = HttpRequest.post(url)
                .execute();
        String body = httpResponse.body();
        System.out.println("httpResponse.body() = " + httpResponse.body());
    }
}
