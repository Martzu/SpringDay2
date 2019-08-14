package com.example.beanTester.persistence.api;


import com.example.beanTester.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    public Optional<User> findById(int id);

    public User save(User user);

    public Optional<User> findByName(String username);

    public List<User> findAll();
}
