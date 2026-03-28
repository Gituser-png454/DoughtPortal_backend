package com.doubtportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doubtportal.entity.Doubt;
import com.doubtportal.service.DoubtService;

import java.util.List;

@RestController
@RequestMapping("/api/doubts")
public class DoubtController {

    @Autowired
    private DoubtService service;

    @PostMapping
    public ResponseEntity<Doubt> postDoubt(@RequestBody Doubt doubt) {
        return ResponseEntity.ok(service.save(doubt));
    }

    @GetMapping
    public ResponseEntity<List<Doubt>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doubt> getById(@PathVariable Long id) {
        Doubt d = service.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
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