package com.example.consumer.service.impl;

import com.example.consumer.service.FibonacciService;
import org.springframework.stereotype.Service;

@Service
public class FibonnacciServiceImpl implements FibonacciService {
    @Override
    public int caculatorFibaonacci(int number) {
        if (number <= 0) return 0;
        if (number == 1) return 1;

        return caculatorFibaonacci(number - 1) + caculatorFibaonacci(number - 2);
    }
}
