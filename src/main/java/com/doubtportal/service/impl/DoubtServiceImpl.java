package com.doubtportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doubtportal.entity.Doubt;
import com.doubtportal.repository.DoubtRepository;
import com.doubtportal.service.DoubtService;

import java.util.List;

@Service
public class DoubtServiceImpl implements DoubtService {

    @Autowired
    private DoubtRepository repo;

    @Override
    public Doubt save(Doubt doubt) {
        return repo.save(doubt);
    }

    @Override
    public List<Doubt> getAll() {
        return repo.findAll();
    }

    @Override
    public Doubt getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Doubt> getByUserId(Long userId) {
        return repo.findByUserId(userId);
    }
}