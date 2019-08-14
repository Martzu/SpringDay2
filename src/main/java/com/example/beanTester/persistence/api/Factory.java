package com.example.beanTester.persistence.api;

public interface Factory {

    public AdminRepository createAdminRepository();

    public UserRepository createUserRepository();
}
