package com.doubtportal.service;

import com.doubtportal.entity.Answer;
import java.util.List;

public interface AnswerService {
    Answer save(Answer answer);
    List<Answer> getAll();
    List<Answer> getByDoubtId(Long doubtId);
}