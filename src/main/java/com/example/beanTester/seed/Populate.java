package com.example.beanTester.seed;


import com.example.beanTester.entity.User;
import com.example.beanTester.persistence.api.Factory;
import com.example.beanTester.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Populate implements CommandLineRunner {

    //private final Factory factory;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //System.out.println(passwordEncoder.encode("salam").toString());

        //userService.createUser("Alex", "$2a$10$cAPBs/qZY1Uiw6LspYiouOa5f3m1XmZt88zooHZuruE6VBPfrKWZ6");
    }
}
