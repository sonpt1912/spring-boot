package com.example.vietqr_api.service.impl;

import com.example.vietqr_api.dto.QrRespone;
import com.example.vietqr_api.dto.TranssactionInfoRequest;
import com.example.vietqr_api.service.VietQrService;
import com.example.vietqr_api.util.Constance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class VietQrServiceImpl implements VietQrService {


    @Value("${vietqr.client-key}")
    private String clientKey;

    @Value("${vietqr.api-key}")
    private String apiKey;

    @Value("${vietqr.url.create-qr}")
    private String createURL;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object createVietQr(TranssactionInfoRequest request) throws URISyntaxException {
        request.setFormat(Constance.VietQr.FORMAT);
        request.setTemplate(Constance.VietQr.TEMPLDATE);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-client-id", clientKey);
        headers.add("x-api-key", apiKey);

        Map<String, Object> map = new HashMap<>();
        map.put("accountNo", request.getAccountNo());
        map.put("accountName", request.getAccountName());
        map.put("acqId", request.getAcqId());
        map.put("amount", request.getAmount());
        map.put("addInfo", request.getAddInfo());
        map.put("format", request.getFormat());
        map.put("template", request.getTemplate());

        log.info(headers.toString());
        log.info(map.toString());

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        log.info(entity.toString());

        ResponseEntity<QrRespone> dataResponse = restTemplate.exchange(createURL, HttpMethod.POST, entity, QrRespone.class);

        return dataResponse;
    }
}
