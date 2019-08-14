package com.example.beanTester.persistence.api;

import com.example.beanTester.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {

    public Optional<Admin> findById(int id);

    public void createAdmin();

    public List<Admin> findAll();

}
