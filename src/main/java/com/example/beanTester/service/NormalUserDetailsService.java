package com.example.beanTester.service;

import com.example.beanTester.entity.User;
import com.example.beanTester.persistence.api.Factory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class NormalUserDetailsService implements UserDetailsService {

    private final Factory factory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = factory.createUserRepository().findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Unknown user"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
