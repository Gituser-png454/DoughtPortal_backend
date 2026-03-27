package com.doubtportal.service;

import com.doubtportal.entity.Doubt;
import java.util.List;

public interface SearchService {
    List<Doubt> search(String keyword);
}