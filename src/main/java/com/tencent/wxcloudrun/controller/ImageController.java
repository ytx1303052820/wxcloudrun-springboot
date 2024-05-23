package com.tencent.wxcloudrun.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class ImageController {

    @GetMapping("/images/{id}/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id,@PathVariable String imageName) throws IOException {
        // 获取图片的路径
        Path imagePath = Paths.get("src/main/resources/static/images/" +id+"/"+imageName);
        // 读取图片的字节数据
        byte[] imageData = Files.readAllBytes(imagePath);
        // 设置响应头信息
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // 或者 MediaType.IMAGE_PNG 等，根据图片格式来设置
                .body(imageData);
    }
}

