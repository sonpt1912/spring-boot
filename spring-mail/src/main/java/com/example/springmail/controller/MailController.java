package com.example.springmail.controller;

import com.example.springmail.service.EmailSenderService;
import com.example.springmail.dto.MailRequest;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private EmailSenderService emailProvider;

    @PostMapping("/send-simple-mail")
    public void sendSimpleMail(@RequestBody MailRequest mailRequest){
        emailProvider.sendSimpleEmail(mailRequest);
    }

    @PostMapping("/send-attchement-mail")
    public void sendAttchementMail(@RequestBody MailRequest mailRequest) throws MessagingException {
        emailProvider.sendMailWithAttachment(mailRequest);
    }

    @PostMapping("/send-template-mail")
    public void sendTemplateMail(@RequestBody MailRequest mailRequest) throws MessagingException, IOException {
        emailProvider.sendTemplateEmail(mailRequest);
    }


}