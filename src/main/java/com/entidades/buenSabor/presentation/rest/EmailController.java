package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//@RestController
//@RequestMapping("/Email")
//@CrossOrigin("*")
//public class EmailController {
//    @Autowired
//    private EmailService emailService;
//
//    @PostMapping("/send")
//    public String sendEmail(@RequestParam(value = "file", required = false)MultipartFile[] file, String to, String[] cc,String subject, String body){
//        return emailService.sendMail(file, to,cc,subject,body);
//    }
//
//
//}
