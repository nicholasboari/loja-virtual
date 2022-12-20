package com.dev.backend.controllers;

import com.dev.backend.entities.ProdutoImagens;
import com.dev.backend.services.ProdutoImagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/produtoImagens")
public class ProdutoImagensController {

    @Autowired
    public ProdutoImagensService produtoImagensService;

    @GetMapping("/{id}")
    public ProdutoImagens buscarPorId(@PathVariable("id") Long id) {
        return produtoImagensService.buscarPorId(id);
    }

    @GetMapping("/")
    public List<ProdutoImagens> buscarTodos() {
        return produtoImagensService.buscarTodos();
    }

    @PostMapping("/")
    public ProdutoImagens inserir(@RequestParam("produtoId") Long produtoId, @RequestParam("file") MultipartFile file) {
        return produtoImagensService.inserir(produtoId, file);
    }

    @PutMapping("/")
    public ProdutoImagens alterar(@RequestBody ProdutoImagens produtoImagens) {
        return produtoImagensService.alterar(produtoImagens);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        produtoImagensService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
