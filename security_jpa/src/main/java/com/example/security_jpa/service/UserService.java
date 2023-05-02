package com.example.security_jpa.service;

import com.example.security_jpa.models.User;
import com.example.security_jpa.models.UserCustomDetails;
import com.example.security_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // kiểm tra xem user có tồn tại trong db không.
        User user = repository.findByUsername(username);
        if (user == null) {
            return null;
        }
        return new UserCustomDetails(user);
    }
}
