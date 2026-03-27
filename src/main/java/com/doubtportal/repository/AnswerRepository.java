package com.doubtportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.doubtportal.entity.Answer;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByDoubtId(Long doubtId);
}