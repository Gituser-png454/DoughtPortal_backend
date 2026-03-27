package com.doubtportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.doubtportal.entity.Answer;
import com.doubtportal.service.AnswerService;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
@CrossOrigin(origins = "http://localhost:5173")
public class AnswerController {

    @Autowired
    private AnswerService service;

    @PostMapping
    public ResponseEntity<Answer> add(@RequestBody Answer answer) {
        return ResponseEntity.ok(service.save(answer));
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/doubt/{doubtId}")
    public ResponseEntity<List<Answer>> getByDoubt(@PathVariable Long doubtId) {
        return ResponseEntity.ok(service.getByDoubtId(doubtId));
    }
}