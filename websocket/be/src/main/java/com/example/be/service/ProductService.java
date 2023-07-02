package com.example.be.service;

import com.example.be.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product save(Product product);

}
