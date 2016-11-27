package com.jyw.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/11/8.
 */
@Controller
public class MainController {


    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        // 获取Session
        return "test";
    }
}
