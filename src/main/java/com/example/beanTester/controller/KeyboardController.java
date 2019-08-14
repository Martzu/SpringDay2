package com.example.beanTester.controller;

import com.example.beanTester.persistence.api.Factory;
import com.example.beanTester.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class KeyboardController implements CommandLineRunner {

    private final UserService userService;
    @Override
    public void run(String... args) throws Exception {
        userService.findAll().forEach(x -> System.out.println(x.toString()));
    }
}
