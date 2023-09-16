package com.example.spring_email.service;

import com.example.spring_email.dto.EmailRequest;
import jakarta.mail.internet.MimeMessage;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.StringWriter;

@Service
public class TemplateEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @Value("classpath:email-template.vm")
    private org.springframework.core.io.Resource resource;

    public void sendOTPTemplate(EmailRequest request) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        VelocityContext velocityContext = new VelocityContext();

        velocityContext.put("subject", request.getSubject());
        velocityContext.put("otp", request.getOtp());

        StringWriter stringWriter = new StringWriter();
        velocityEngine.mergeTemplate(resource.getFilename(), "UTF-8", velocityContext, stringWriter);

        String emailContent = stringWriter.toString();

        messageHelper.setTo(request.getTo());
        messageHelper.setSubject(request.getSubject());
        messageHelper.setText(emailContent, true);

        javaMailSender.send(mimeMessage);


    }

}
