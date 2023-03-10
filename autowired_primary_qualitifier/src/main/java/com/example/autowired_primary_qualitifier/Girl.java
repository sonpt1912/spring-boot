package com.example.autowired_primary_qualitifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Girl {
    // đánh dấu spring inject một đối tượng vào đây
    private Outfit outfit;

    // spring sẽ inject thông qua contructor trước
    public Girl() {
    }

    @Autowired
    // nếu không thấy contructor thỏa mãn sẽ thông qua getter và setter
    /*
     * có 2 cách để loại bỏ lỗi
     * c1: sử dụng @Primary
     * c2: sử dụng @Qualitifier:
     * + đặt teen cho các component: @component("naked")
     * + sử dụng @Qualifier("naked"): Girl(@Qualifier("naked") Outfit outfit)
     * */ public Girl(@Qualifier("bikini") Outfit outfit) {
        this.outfit = outfit;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }
}
