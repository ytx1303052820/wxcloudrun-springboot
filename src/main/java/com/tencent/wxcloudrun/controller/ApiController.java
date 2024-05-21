package com.tencent.wxcloudrun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tencent.wxcloudrun.dao.SocialEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ApiController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ApiController.class);

    @Autowired
    SocialEventRepo userRepo;

    @GetMapping("/get_data")
    String getData(HttpServletRequest request){
        return "Hello "+request.getRemoteAddr();
    }

    @GetMapping("/get_social_event")
    String getSocialEvent() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return objectMapper.writeValueAsString(userRepo.findAll());
    }
}

