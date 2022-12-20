package com.dev.backend.controllers;

import com.dev.backend.entities.Permissao;
import com.dev.backend.services.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {
    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> buscarTodos() {
        return permissaoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Permissao buscarPorId(@PathVariable("id") Long id) {
        return permissaoService.buscarPorId(id);
    }

    @PostMapping("/")
    public Permissao inserir(@RequestBody Permissao objeto) {
        return permissaoService.inserir(objeto);
    }

    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao objeto) {
        return permissaoService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
