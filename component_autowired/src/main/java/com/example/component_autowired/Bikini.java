package com.example.component_autowired;

import org.springframework.stereotype.Component;

@Component
public class Bikini implements Outfit{
    @Override
    public void wear() {
        System.out.println("đã được mặc bikini");
    }
}
