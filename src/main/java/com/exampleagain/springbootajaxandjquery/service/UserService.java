package com.exampleagain.springbootajaxandjquery.service;

import com.exampleagain.springbootajaxandjquery.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> findAllUsers();
    void removeUser(Long id);
    User findUserById(Long id);
    User findUserByEmail(String email);
}
