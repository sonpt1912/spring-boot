package com.example.component_autowired;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Girl {
    @Autowired
    Outfit outfit;
    public Girl(Outfit outfit){
        this.outfit = outfit;
    }

}
