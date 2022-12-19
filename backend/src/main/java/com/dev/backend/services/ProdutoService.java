package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.Produto;
import com.dev.backend.repositories.MarcaRepository;
import com.dev.backend.repositories.ProdutoRepository;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  MarcaRepository marcaRepository;

  public List<Produto> buscarTodos() {
    return produtoRepository.findAll();
  }

  public Produto buscarPorId(Long id) {
    return produtoRepository.findById(id).get();
  }

  public Produto inserir(Produto obj) {
    obj.setDataCriacao(new Date());
    obj.setMarca(marcaRepository.findById(obj.getMarca().getId()).get());
    return produtoRepository.save(obj);
  }

  public Produto alterar(Produto obj) {
    obj.setDataAtualizacao(new Date());
    return produtoRepository.saveAndFlush(obj);
  }

  public void excluir(Long id) {
    Produto pessoa = produtoRepository.findById(id).get();
    produtoRepository.delete(pessoa);
  }
}
