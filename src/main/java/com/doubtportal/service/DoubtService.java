package com.doubtportal.service;

import com.doubtportal.entity.Doubt;
import java.util.List;

public interface DoubtService {
    Doubt save(Doubt doubt);
    List<Doubt> getAll();
    Doubt getById(Long id);
    void delete(Long id);
    List<Doubt> getByUserId(Long userId);
}