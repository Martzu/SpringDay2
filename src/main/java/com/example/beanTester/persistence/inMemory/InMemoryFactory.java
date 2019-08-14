package com.example.beanTester.persistence.inMemory;

import com.example.beanTester.persistence.api.AdminRepository;
import com.example.beanTester.persistence.api.Factory;
import com.example.beanTester.persistence.api.UserRepository;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Data
@Component
@ConditionalOnProperty(name = "repository-type", havingValue = "MEM")
public class InMemoryFactory implements Factory {


    private final AdminRepository adminRepository = new InMemoryAdminRepository();
    private final UserRepository userRepository = new InMemoryUserRepository();
    @Override
    public AdminRepository createAdminRepository() {
        return adminRepository;
    }

    @Override
    public UserRepository createUserRepository() {
        return userRepository;
    }
}
