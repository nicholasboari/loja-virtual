package com.dev.backend.services;

import com.dev.backend.entities.Permissao;
import com.dev.backend.entities.Pessoa;
import com.dev.backend.repositories.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoService {
    @Autowired
    private PermissaoRepository permissaoRepository;

    public Permissao buscarPorId(Long id) {
        return permissaoRepository.findById(id).get();
    }

    public List<Permissao> buscarTodos() {
        return permissaoRepository.findAll();
    }

    public Permissao inserir(Permissao obj) {
        obj.setDataCriacao(new Date());
        Permissao permissaoNovo = permissaoRepository.saveAndFlush(obj);
        return permissaoNovo;
    }

    public Permissao alterar(Permissao obj) {
        obj.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        Permissao permissao = permissaoRepository.findById(id).get();
        permissaoRepository.delete(permissao);
    }
}
