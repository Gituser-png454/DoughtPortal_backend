package com.doubtportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doubtportal.entity.Doubt;
import com.doubtportal.service.SearchService;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService service;

    @GetMapping
    public ResponseEntity<List<Doubt>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(service.search(keyword));
    }
}