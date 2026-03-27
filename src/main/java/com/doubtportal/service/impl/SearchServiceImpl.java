package com.doubtportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doubtportal.entity.Doubt;
import com.doubtportal.repository.DoubtRepository;
import com.doubtportal.service.SearchService;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private DoubtRepository repo;

    @Override
    public List<Doubt> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return repo.findAll();
        }
        return repo.searchByKeyword(keyword.trim());
    }
}