package com.apistory.interfaces.controller;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.URLUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称 API
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet() {
        return "GET 你的名字是: GAT";
    }

    @PostMapping("/post")
    public String getNameByPost(HttpServletRequest httpServletRequest) {
        String body = URLUtil.decode(httpServletRequest.getHeader("body"), CharsetUtil.CHARSET_UTF_8);
        return "POST 你的名字是" + body;
    }
}
