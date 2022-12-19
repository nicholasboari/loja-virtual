package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.Marca;
import com.dev.backend.repositories.MarcaRepository;

@Service
public class MarcaService {

  @Autowired
  private MarcaRepository marcaRepository;

  public Marca buscarPorId(Long id) {
    return marcaRepository.findById(id).get();
  }

  public List<Marca> buscarTodos() {
    return marcaRepository.findAll();
  }

  public Marca inserir(Marca obj) {
    obj.setDataCriacao(new Date());
    Marca marcaNovo = marcaRepository.saveAndFlush(obj);
    return marcaNovo;
  }

  public Marca alterar(Marca obj) {
    obj.setDataAtualizacao(new Date());
    return marcaRepository.saveAndFlush(obj);
  }

  public void excluir(Long id) {
    Marca marca = marcaRepository.findById(id).get();
    marcaRepository.delete(marca);
  }
}
