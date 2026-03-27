package com.doubtportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.doubtportal.entity.Doubt;
import com.doubtportal.service.DoubtService;

import java.util.List;

@RestController
@RequestMapping("/api/doubts")
@CrossOrigin(origins = "http://localhost:5173")
public class DoubtController {

    @Autowired
    private DoubtService service;

    @PostMapping
    public ResponseEntity<Doubt> add(@RequestBody Doubt doubt) {
        return ResponseEntity.ok(service.save(doubt));
    }

    @GetMapping
    public ResponseEntity<List<Doubt>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doubt> getById(@PathVariable Long id) {
        Doubt doubt = service.getById(id);
        if (doubt == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(doubt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Doubt>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }
}