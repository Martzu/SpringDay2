package com.example.beanTester.service;


import com.example.beanTester.entity.Admin;
import com.example.beanTester.persistence.api.Factory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final Factory factory;

    public void createAdmin()
    {
        factory.createAdminRepository().createAdmin();
    }

    public Optional<Admin> findById(int id)
    {
        return factory.createAdminRepository().findById(id);
    }

    public List<Admin> findAll()
    {
        return factory.createAdminRepository().findAll();
    }
}
