package com.example.springmail.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmailVariable {

    private String name;

    private String location;

    private String sign;

}
