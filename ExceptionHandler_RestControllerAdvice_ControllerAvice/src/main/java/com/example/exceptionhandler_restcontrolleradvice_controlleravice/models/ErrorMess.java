package com.example.exceptionhandler_restcontrolleradvice_controlleravice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ErrorMess {
    private int statusCode;
    private String message;
}
