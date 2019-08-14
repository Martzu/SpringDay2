package com.example.beanTester.persistence.jdbc;

import com.example.beanTester.persistence.api.AdminRepository;
import com.example.beanTester.persistence.api.Factory;
import com.example.beanTester.persistence.api.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name="repository-type", havingValue = "JDBC")
public class JdbcFactory implements Factory {

    private final JdbcTemplate template;

    @Override
    public AdminRepository createAdminRepository() {
        return null;
    }

    @Override
    public UserRepository createUserRepository() {
        return new JdbcUserRepository(template);
    }
}
