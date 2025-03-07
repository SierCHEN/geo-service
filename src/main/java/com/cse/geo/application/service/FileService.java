package com.cse.geo.application.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FileService {
    public byte[] getImageAsBytes() throws IOException {
        // 从类路径下的 static 文件夹中加载图片
        ClassPathResource imageFile = new ClassPathResource("static/hp1.png");

        // 将图片文件读取为字节数组
        InputStream inputStream = imageFile.getInputStream();
        byte[] imageBytes = inputStream.readAllBytes();
        inputStream.close();

        return imageBytes;
    }

    public byte[] getPdfAsBytes() throws IOException {
        // 从类路径下的 static 文件夹中加载pdf
        ClassPathResource pdfFile = new ClassPathResource("static/certification.pdf");

        // 将pdf文件读取为字节数组
        InputStream inputStream = pdfFile.getInputStream();
        byte[] pdfBytes = inputStream.readAllBytes();
        inputStream.close();

        return pdfBytes;
    }
}
