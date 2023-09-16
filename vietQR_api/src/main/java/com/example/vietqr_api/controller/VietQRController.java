package com.example.vietqr_api.controller;

import com.example.vietqr_api.dto.TranssactionInfoRequest;
import com.example.vietqr_api.service.VietQrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/viet-qr")
public class VietQRController {


    @Autowired
    private VietQrService service;


    @PostMapping("/create")
    public ResponseEntity createQr(@RequestBody TranssactionInfoRequest request) throws URISyntaxException {
        return ResponseEntity.ok(service.createVietQr(request));
    }


}
