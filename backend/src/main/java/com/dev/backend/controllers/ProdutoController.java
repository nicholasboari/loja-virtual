package com.dev.backend.controllers;

import com.dev.backend.entities.Produto;
import com.dev.backend.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable("id") Long id) {
        return produtoService.buscarPorId(id);
    }

    @GetMapping("/")
    public List<Produto> buscarTodos() {
        return produtoService.buscarTodos();
    }

    @PostMapping("/")
    public Produto inserir(@RequestBody Produto pessoa) {
        return produtoService.inserir(pessoa);
    }

    @PutMapping("/")
    public Produto alterar(@RequestBody Produto pessoa) {
        return produtoService.alterar(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

