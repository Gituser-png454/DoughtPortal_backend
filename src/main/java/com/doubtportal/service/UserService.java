package com.doubtportal.service;

import com.doubtportal.entity.User;

public interface UserService {
    User register(User user);
    User login(String email, String password);
    User getById(Long id);
}