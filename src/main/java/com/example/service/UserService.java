package com.example.service;


import com.example.domain.User;

public interface UserService {

    User findByLogin(String login);
    Iterable<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    void updateUser(Long id, User user);

}
