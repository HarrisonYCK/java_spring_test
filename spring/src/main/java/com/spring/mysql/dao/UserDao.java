package com.spring.mysql.dao;

import com.spring.mysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    public User findUserByUsername(String username);
}
