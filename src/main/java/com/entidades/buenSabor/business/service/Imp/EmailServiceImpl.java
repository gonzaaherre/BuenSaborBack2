package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String sender;
    @Autowired
    private JavaMailSender javaMailSender;



    @Override
    public String sendMail(byte[] file, String to, String[] cc, String subject, String body, String attachmentFilename) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(to);

            if (cc != null && cc.length > 0) {
                mimeMessageHelper.setCc(cc);
            }

            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);

            if (file != null) {
                mimeMessageHelper.addAttachment(
                        attachmentFilename,
                        new ByteArrayResource(file)
                );
            }

            javaMailSender.send(mimeMessage);
            return "Mail sent successfully";

        } catch (Exception e) {
            throw new RuntimeException("Error while sending email: " + e.getMessage(), e);
        }
    }
}
