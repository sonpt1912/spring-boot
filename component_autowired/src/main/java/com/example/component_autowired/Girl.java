package com.example.component_autowired;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
// @Scope("singleton") // default sẽ là singleton
// nếu muốn mỗi lần chạy sẽ tạo ra 1 instance mới thì sẽ sử dụng thộc tính protycon
public class Girl {
    @Autowired
    Outfit outfit;
    public Girl(Outfit outfit){
        this.outfit = outfit;
    }

}
