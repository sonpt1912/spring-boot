package com.example.autowired_primary_qualitifier;

import org.springframework.stereotype.Component;

@Component("bikini")
public class Bikini implements Outfit{

    @Override
    public String wear() {
        return "mặc bikini";
    }
}
