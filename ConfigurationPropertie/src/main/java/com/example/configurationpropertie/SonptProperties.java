package com.example.configurationpropertie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component // là 1 bean
// @PropertySource("classpath:sonpt.yml") đánh dấu đ lấy config từ trong file sonpt.yml
// nếu không có annoation này thì spring sẽ mặc định gọi (classpath:application.yml trong resources)
@ConfigurationProperties(prefix = "sonpt")
// chỉ lấy các config có tiền tố là "sonpt"
public class SonptProperties {

    private String email;

    private String googleAnalyticsId;

    /*
     * ngoài ra để chạy cần kích hoạc annotation @EnableConfigurationProperties
     * lên một configuration nào đó.
     * */

    /*
    * chúng ta có thể config các thuộc tính bên trong class k cả khi nó
    * là List, Map hay một class khác
    * */

    private List<Authors> authors;
}
