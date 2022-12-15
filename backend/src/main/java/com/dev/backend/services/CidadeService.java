package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.Cidade;
import com.dev.backend.repositories.CidadeRepository;
import com.dev.backend.repositories.EstadoRepository;

@Service
public class CidadeService {

  @Autowired
  private CidadeRepository cidadeRepository;

  @Autowired
  private EstadoRepository estadoRepository;

  public Cidade buscarPorId(Long id) {
    return cidadeRepository.findById(id).get();
  }

  public List<Cidade> buscarTodos() {
    return cidadeRepository.findAll();
  }

  public Cidade inserir(Cidade obj) {
    obj.setDataCriacao(new Date());
    obj.setEstado(estadoRepository.findById(obj.getEstado().getId()).get());
    return cidadeRepository.saveAndFlush(obj);
  }

  public Cidade alterar(Cidade obj) {
    obj.setDataAtualizacao(new Date());
    return cidadeRepository.saveAndFlush(obj);
  }

  public void excluir(Long id) {
    Cidade cidade = cidadeRepository.findById(id).get();
    cidadeRepository.delete(cidade);
  }
}
