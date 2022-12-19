package com.dev.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entities.Categoria;
import com.dev.backend.services.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

  @Autowired
  public CategoriaService categoriaService;

  @GetMapping("/{id}")
  public Categoria buscarPorId(@PathVariable("id") Long id) {
    return categoriaService.buscarPorId(id);
  }

  @GetMapping("/")
  public List<Categoria> buscarTodos() {
    return categoriaService.buscarTodos();
  }

  @PostMapping("/")
  public Categoria inserir(@RequestBody Categoria categoria) {
    return categoriaService.inserir(categoria);
  }

  @PutMapping("/")
  public Categoria alterar(@RequestBody Categoria categoria) {
    return categoriaService.alterar(categoria);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
    categoriaService.excluir(id);
    return ResponseEntity.ok().build();
  }
}
