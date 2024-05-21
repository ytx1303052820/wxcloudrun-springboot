package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ApiController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ApiController.class);

    @Autowired
    UserRepo userRepo;

    @GetMapping("/get_data")
    String getData(HttpServletRequest request){
        log.info("here"+request.getRemoteAddr());
        log.info("userRepo:"+userRepo.findAll());

        return "Hello "+userRepo.findAll()+request.getRemoteAddr();
    }
}

