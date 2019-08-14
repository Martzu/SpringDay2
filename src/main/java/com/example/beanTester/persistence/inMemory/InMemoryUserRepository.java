package com.example.beanTester.persistence.inMemory;

import com.example.beanTester.entity.User;
import com.example.beanTester.persistence.api.UserRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUserRepository implements UserRepository {

    private final Map<Integer, User> data = new ConcurrentHashMap<>();

    private final AtomicInteger currentId = new AtomicInteger(0);
    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(currentId.incrementAndGet());
        }
        data.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findByName(String username) {
        for(User user : data.values())
        {
            if(user.getUsername().equals(username))
            {
                return Optional.ofNullable(user);
            }
        }
        return Optional.ofNullable(null);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(data.values());
    }
}
