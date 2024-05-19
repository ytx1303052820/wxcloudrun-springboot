package com.tencent.wxcloudrun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ApiController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/get_data")
    String getData(HttpServletRequest request){
        log.info("here"+request.getRemoteAddr());

        return "Hello World"+request.getRemoteAddr();
    }
}

