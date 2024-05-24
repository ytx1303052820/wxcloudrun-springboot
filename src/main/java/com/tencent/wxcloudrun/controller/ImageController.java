package com.tencent.wxcloudrun.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

@RestController
public class ImageController {

    private final ResourceLoader resourceLoader;

    public ImageController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/images/{id}/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id, @PathVariable String imageName) {
        try {
            // 获取图片的资源路径
            Resource resource = resourceLoader.getResource("classpath:static/images/" + id + "/" + imageName);

            // 检查资源是否存在
            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 读取图片的字节数据
            InputStream inputStream = resource.getInputStream();
            byte[] imageData = IOUtils.toByteArray(inputStream);

            // 设置响应头信息
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // 或者 MediaType.IMAGE_PNG 等，根据图片格式来设置
                    .body(imageData);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
