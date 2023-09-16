package com.example.vietqr_api.service;


import com.example.vietqr_api.dto.TranssactionInfoRequest;

import java.net.URISyntaxException;

public interface VietQrService {

    Object createVietQr(TranssactionInfoRequest request) throws URISyntaxException;

}
