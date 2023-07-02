package com.example.be.controller;

import com.example.be.model.Product;
import com.example.be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/get-all")
    public List<Product> products() {
        return service.getAll();
    }

    @MessageMapping("/save")
    // @MessageMapping("/products") định nghĩa một endpoint "/products" dùng để xử lý message được gửi đến từ client thông qua kết nối WebSocket.
    @SendTo("/topic/product")
    // @SendTo("/topic/product") được sử dụng để định nghĩa đường đi (destination) cho kết quả trả về từ message broker.
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }

}
