package com.example.consumer.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomMessage {

    private String messageId;

    private String message;

    private Date messageDate;

}
