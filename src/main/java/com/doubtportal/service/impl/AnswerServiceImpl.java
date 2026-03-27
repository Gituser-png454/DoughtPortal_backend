package com.doubtportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doubtportal.entity.Answer;
import com.doubtportal.repository.AnswerRepository;
import com.doubtportal.service.AnswerService;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository repo;

    @Override
    public Answer save(Answer answer) {
        return repo.save(answer);
    }

    @Override
    public List<Answer> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Answer> getByDoubtId(Long doubtId) {
        return repo.findByDoubtId(doubtId);
    }
}