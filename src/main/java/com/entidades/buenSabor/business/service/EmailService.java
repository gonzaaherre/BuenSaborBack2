package com.entidades.buenSabor.business.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmailService {

    String sendMail(byte[] file, String to, String[] cc, String subject, String body, String attachmentFilename);
}
