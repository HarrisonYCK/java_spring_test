package com.spring.mysql.service;

import com.spring.mysql.dao.UserDao;
import com.spring.mysql.model.User;
import com.spring.mysql.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserDataAccessService implements UserDetailsService {
    @Autowired
    private UserDao repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findUserByUsername(username);
        if (user==null)
            throw new UsernameNotFoundException("User not found");

        return new UserPrincipal(user);
    }
}
