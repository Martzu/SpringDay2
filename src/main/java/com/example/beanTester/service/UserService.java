package com.example.beanTester.service;

import com.example.beanTester.entity.User;
import com.example.beanTester.persistence.api.Factory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final Factory factory;
    private final PasswordEncoder passwordEncoder;
    public void createUser(String username, String password)
    {
        User user = new User(username, password);
        factory.createUserRepository().save(user);
    }

    public Optional<User> findById(int id)
    {
        return factory.createUserRepository().findById(id);
    }

    public List<User> findAll()
    {
        return factory.createUserRepository().findAll();
    }

    public Optional<User> findByName(String username)
    {
        return factory.createUserRepository().findByName(username);
    }
}
