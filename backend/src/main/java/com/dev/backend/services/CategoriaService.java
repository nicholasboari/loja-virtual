package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.Categoria;
import com.dev.backend.repositories.CategoriaRepository;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  public Categoria buscarPorId(Long id) {
    return categoriaRepository.findById(id).get();
  }

  public List<Categoria> buscarTodos() {
    return categoriaRepository.findAll();
  }

  public Categoria inserir(Categoria obj) {
    obj.setDataCriacao(new Date());
    Categoria cateogoriaNovo = categoriaRepository.saveAndFlush(obj);
    return cateogoriaNovo;
  }

  public Categoria alterar(Categoria obj) {
    obj.setDataAtualizacao(new Date());
    return categoriaRepository.saveAndFlush(obj);
  }

  public void excluir(Long id) {
    Categoria cateogoria = categoriaRepository.findById(id).get();
    categoriaRepository.delete(cateogoria);
  }
}
