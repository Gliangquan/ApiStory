package com.apistory.interfaces.controller;


import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baidu")
public class BaiduController {

    @GetMapping("/get")
    public String getBaidu() {
        String url = "https://v2.api-m.com/api/baiduhot";
        HttpResponse httpResponse = HttpRequest.post(url)
                .execute();
        return httpResponse.body();
    }

    @GetMapping("/day")
    public String getDayWord() {
        String url = "https://v.api.aa1.cn/api/yiyan/index.php";
        HttpResponse httpResponse = HttpRequest.post(url)
                .execute();
        return httpResponse.body();
    }
}
