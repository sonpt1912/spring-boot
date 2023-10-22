package com.example.springmail.service;

import com.example.springmail.dto.MailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendSimpleEmail(MailRequest mailRequest) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("hyusdskjfkds");
        mailMessage.setTo(mailRequest.getToEmail());
        mailMessage.setText(mailRequest.getBody());
        mailMessage.setSubject(mailRequest.getSubject());

        mailSender.send(mailMessage);
    }

    public void sendMailWithAttachment(MailRequest mailRequest) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        messageHelper.setFrom("TEST_MAIL");
        messageHelper.setTo(mailRequest.getToEmail());
        messageHelper.setText(mailRequest.getSubject());
        messageHelper.setSubject(mailRequest.getSubject());

        FileSystemResource fileSystemResource = new FileSystemResource(new File(mailRequest.getAttachement()));
        messageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

        mailSender.send(mimeMessage);
    }

    public void sendTemplateEmail(MailRequest mail) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
//
//        helper.addAttachment("template-cover.png", new ClassPathResource("javabydeveloper-email.PNG"));

        Context context = new Context();

        context.setVariables((Map<String, Object>) mail.getEmailVariable());

        String html = templateEngine.process("email-template", context);

        helper.setFrom("TEST_MAIL");
        helper.setTo(mail.getToEmail());
        helper.setText(html, true);
        helper.setSubject(mail.getSubject());

        mailSender.send(message);
    }

}

