package com.doubtportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.doubtportal.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}