package com.example.beanTester.persistence.jdbc;

import com.example.beanTester.entity.User;
import com.example.beanTester.persistence.api.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor

public class JdbcUserRepository implements UserRepository {
    private final JdbcTemplate template;

    @Override
    public Optional<User> findById(int id) {
        List<User> users = template.query("SELECT * FROM normal_user WHERE id = ?",
                (resultSet, i) ->
                        new User(resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password")
                        ), id);
        return users.isEmpty() ? Optional.empty() : Optional.ofNullable(users.get(0));
    }

    @Override
    public User save(User user) {
        if(user.getId() != 0)
        {
            update(user);
        }
        else
        {
            int id = insert(user);
            user.setId(id);
        }
        return user;
    }

    @Override
    public Optional<User> findByName(String username) {
        List<User> users = template.query("SELECT * FROM normal_user WHERE username = ?",
                (resultSet, i) ->
                        new User(resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password")
                        ), username);
        return users.isEmpty() ? Optional.empty() : Optional.ofNullable(users.get(0));
    }

    @Override
    public List<User> findAll() {
        return template.query("SELECT * FROM normal_user",
                (resultSet, i) ->
                        new User(resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password")
                        )
                );
    }

    private int insert(User user)
    {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
        insert.setTableName("normal_user");
        insert.usingGeneratedKeyColumns("id");
        Map<String, Object> data = new HashMap<>();
        data.put("id", user.getId());
        data.put("username", user.getUsername());
        data.put("password", user.getPassword());
        return insert.executeAndReturnKey(data).intValue();
    }

    private void update(User user)
    {
        template.update("UPDATE normal_user SET username = ?, password = ? WHERE id = ?", user.getUsername(), user.getPassword(), user.getId());
    }

}
