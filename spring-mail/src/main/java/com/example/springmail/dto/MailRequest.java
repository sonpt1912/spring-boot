package com.example.springmail.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MailRequest {
    private String toEmail;
    private String body;
    private String subject;
    private EmailVariable emailVariable;
    private String attachement;
}
