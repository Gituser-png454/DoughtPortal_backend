package com.doubtportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doubtportal.entity.User;
import com.doubtportal.repository.UserRepository;
import com.doubtportal.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository repo;

    @Override
    public User login(String email, String password) {
        User user = repo.findByEmail(email);

        if (user != null && user.getPassword() != null 
                && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}