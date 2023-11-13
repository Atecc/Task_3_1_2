package com.example.Task312.services;


import com.example.Task312.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User show(int id);
    void save(User user);
    void delete(int id);
    void update(int id,User user);
}
