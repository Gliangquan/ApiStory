package com.apistory.sdk.client;

import cn.hutool.http.HttpRequest;

public class MyHttpRequest extends HttpRequest {
    public MyHttpRequest(String url) {
        super(url);
    }
}