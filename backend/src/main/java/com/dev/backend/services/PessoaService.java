package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.Pessoa;
import com.dev.backend.repositories.CidadeRepository;
import com.dev.backend.repositories.PessoaRepository;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository pessoaRepository;

  @Autowired
  private CidadeRepository cidadeRepository;

  public List<Pessoa> buscarTodos() {
    return pessoaRepository.findAll();
  }

  public Pessoa buscarPorId(Long id) {
    return pessoaRepository.findById(id).get();
  }

  public Pessoa inserir(Pessoa obj) {
    obj.setDataCriacao(new Date());
    obj.setCidade(cidadeRepository.findById(obj.getCidade().getId()).get());
    return pessoaRepository.save(obj);
  }

  public Pessoa alterar(Pessoa obj) {
    obj.setDataAtualizacao(new Date());
    return pessoaRepository.saveAndFlush(obj);
  }

  public void excluir(Long id) {
    Pessoa pessoa = pessoaRepository.findById(id).get();
    pessoaRepository.delete(pessoa);
  }
}
