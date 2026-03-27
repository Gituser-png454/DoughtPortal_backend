package com.doubtportal.service;

import com.doubtportal.entity.User;

public interface AuthService {

    User login(String email, String password);

}