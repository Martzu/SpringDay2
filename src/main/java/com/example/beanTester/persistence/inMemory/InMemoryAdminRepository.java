package com.example.beanTester.persistence.inMemory;

import com.example.beanTester.entity.Admin;
import com.example.beanTester.persistence.api.AdminRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Data
@RequiredArgsConstructor
public class InMemoryAdminRepository implements AdminRepository {

    private final Map<Integer, Admin> data = new ConcurrentHashMap<>();
    @Override
    public Optional<Admin> findById(int id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public void createAdmin() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedKey = new String(array, Charset.forName("UTF-8"));
        data.put(data.size(), new Admin((int) Math.random(), generatedKey));
    }

    @Override
    public List<Admin> findAll() {
        return new ArrayList<>(data.values());
    }
}
