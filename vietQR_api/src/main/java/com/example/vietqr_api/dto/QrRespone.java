package com.example.vietqr_api.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class QrRespone {

    private String code;

    private String desc;

    private Object data;

}
