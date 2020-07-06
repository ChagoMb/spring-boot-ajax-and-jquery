package com.exampleagain.springbootajaxandjquery.repository;

import com.exampleagain.springbootajaxandjquery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
