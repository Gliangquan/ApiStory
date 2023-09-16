package com.apistory.sdk.client;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

public class MyHttpRequest extends HttpRequest {
    public MyHttpRequest(String url) {
        super(url);
    }
}