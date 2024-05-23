package com.tencent.wxcloudrun.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class ZipController {

    @GetMapping("/downloadZip/{id}")
    public ResponseEntity<ByteArrayResource> downloadZip(@PathVariable String id) {
        String fileName = id+".zip";
        // 定义zip文件路径
        String zipFilePath = "static/images/"+fileName;

        try {
            // 读取zip文件的字节数组
            ClassPathResource resource = new ClassPathResource(zipFilePath);
            InputStream inputStream = resource.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            byte[] data = baos.toByteArray();
            inputStream.close();

            // 设置响应头信息
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", fileName);

            // 返回zip文件的字节数组
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(data.length)
                    .body(new ByteArrayResource(data));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
