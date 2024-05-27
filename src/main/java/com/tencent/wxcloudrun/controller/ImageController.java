package com.tencent.wxcloudrun.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ImageController {

    private final ResourceLoader resourceLoader;

    public ImageController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/images/{id}/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id, @PathVariable String imageName, HttpServletRequest request) {
        try {
            // 获取图片的资源路径
            Resource resource = resourceLoader.getResource("classpath:static/images/" + id + "/" + imageName);

            // 检查资源是否存在
            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 检查客户端是否发送了 If-None-Match 头
            String ifNoneMatch = request.getHeader("If-None-Match");
            String currentEtag = calculateEtag(resource); // 计算当前资源的 ETag

            if (ifNoneMatch != null && ifNoneMatch.equals(currentEtag)) {
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
            }

            // 设置 Last-Modified 头
            long lastModified = resource.lastModified();
            String lastModifiedString = ZonedDateTime.ofInstant(Instant.ofEpochMilli(lastModified), ZoneId.of("GMT"))
                    .format(DateTimeFormatter.RFC_1123_DATE_TIME);

            HttpHeaders headers = new HttpHeaders();
            headers.setLastModified(lastModified);

            System.out.println(currentEtag);
            // 设置 ETag 头
            headers.setETag("\""+currentEtag+"\"");

            // 设置响应头信息
            byte[] imageData = Files.readAllBytes(resource.getFile().toPath());
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imageData);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private String calculateEtag(Resource resource) throws IOException {
        // 此处可以使用资源内容的哈希值或其他算法来生成 ETag
        // 这里简单地使用文件的最后修改时间作为 ETag
        long lastModified = resource.lastModified();
        return String.valueOf(lastModified);
    }



}
