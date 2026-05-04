package com.richard.provateste.controller;

import com.richard.provateste.models.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private static final List<Employee> funcionarios = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Employee>> listar() {
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> buscarPorId(@PathVariable Long id) {
        return funcionarios.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> criar(@RequestBody Employee employee) {
        funcionarios.add(employee);
        return ResponseEntity.status(201).body(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = funcionarios.removeIf(e -> e.getId().equals(id));
        if (removido) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
