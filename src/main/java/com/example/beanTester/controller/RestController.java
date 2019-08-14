package com.example.beanTester.controller;


import com.example.beanTester.entity.User;
import com.example.beanTester.service.AdminService;
import com.example.beanTester.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final UserService userService;
    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return userService.findAll();
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user)
    {
        userService.createUser(user.getUsername(), user.getPassword());
    }


}
