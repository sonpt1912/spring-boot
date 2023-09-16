package com.example.vietqr_api.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TranssactionInfoRequest {

    private String accountNo;

    private String accountName;

    private Integer acqId;

    private Integer amount;

    private String addInfo;

    private String format;

    private String template;
}
