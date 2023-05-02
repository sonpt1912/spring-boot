package com.example.security_jpa.security;

import com.example.security_jpa.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        // password encoder, để spring security sử dụng mã hóa mật khẩu người dùng
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService) // cung cấp userservice cho spring security
                .passwordEncoder(passwordEncoder()); // cung cấp password cho endcode
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/", "/home").permitAll() // cho phép all truy cập vào 2 đường dẫn này
                .anyRequest().authenticated() // tất cả request khác đều phải xác thực mới được truy ập
                .and()
                .formLogin() // xác thực bằng form login
                .defaultSuccessUrl("/hello")
                .permitAll() // tất cả đều được vào địa chỉ này
                .and()
                .logout() // cho phép logout
                .permitAll();
    }


}
