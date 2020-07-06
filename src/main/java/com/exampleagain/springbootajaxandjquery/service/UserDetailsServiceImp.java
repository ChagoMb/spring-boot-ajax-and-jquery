package com.exampleagain.springbootajaxandjquery.service;

import com.exampleagain.springbootajaxandjquery.model.Role;
import com.exampleagain.springbootajaxandjquery.model.User;
import com.exampleagain.springbootajaxandjquery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public UserDetailsServiceImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findUserByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
