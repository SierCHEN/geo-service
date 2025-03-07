package com.cse.geo.application.api;

import com.cse.geo.application.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FileApi {
    @Autowired
    private FileService fileService;

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage() throws IOException {
        // 调用服务类获取图片的字节数组
        byte[] imageBytes = fileService.getImageAsBytes();

        // 返回图片字节数组和 HTTP 状态码 200
        return ResponseEntity.ok().body(imageBytes);
    }

    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getPdf() throws IOException {
        // 调用服务类获取pdf的字节数组
        byte[] pdfBytes = fileService.getPdfAsBytes();

        // 返回pdf字节数组和 HTTP 状态码 200
        return ResponseEntity.ok().body(pdfBytes);
    }
}
