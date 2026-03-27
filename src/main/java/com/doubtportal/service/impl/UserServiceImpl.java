package com.doubtportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doubtportal.entity.User;
import com.doubtportal.repository.UserRepository;
import com.doubtportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User register(User user) {
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("STUDENT");
        }
        return repo.save(user);
    }

    @Override
    public User login(String email, String password) {
        User user = repo.findByEmail(email);
        if (user != null && user.getPassword() != null
                && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public User getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}