package com.richard.provateste.controller;

import com.richard.provateste.models.Manager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    private static final List<Manager> gerentes = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Manager>> listar() {
        return ResponseEntity.ok(gerentes);
    }

    @PostMapping
    public ResponseEntity<Manager> criar(@RequestBody Manager manager) {
        gerentes.add(manager);
        return ResponseEntity.status(201).body(manager);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manager> atualizar(@PathVariable Long id, @RequestBody Manager atualizado) {
        Manager manager = gerentes.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (manager != null) {
            atualizado.setId(id);
            gerentes.set(gerentes.indexOf(manager), atualizado);
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
