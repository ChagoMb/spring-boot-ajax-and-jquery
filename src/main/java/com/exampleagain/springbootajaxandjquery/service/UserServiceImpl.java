package com.exampleagain.springbootajaxandjquery.service;

import com.exampleagain.springbootajaxandjquery.model.User;
import com.exampleagain.springbootajaxandjquery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    private BCryptPasswordEncoder bCrypt;

    @Autowired
    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder bCrypt) {
        this.repository = repository;
        this.bCrypt = bCrypt;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
        repository.save(user);
    }

    @Override
    @Transactional
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public User findUserById(Long id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public User findUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }
}
