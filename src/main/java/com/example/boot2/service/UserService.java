package com.example.boot2.service;

import com.example.boot2.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save();

    List<User> fetchUserList();

    void deleteUser(User user);

    Optional<User> getUserById(Long id);
}
