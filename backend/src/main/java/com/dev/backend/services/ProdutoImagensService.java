package com.dev.backend.services;

import com.dev.backend.entities.Produto;
import com.dev.backend.entities.ProdutoImagens;
import com.dev.backend.repositories.ProdutoImagensRepository;
import com.dev.backend.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoImagensService {

    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoImagens buscarPorId(Long id) {
        return produtoImagensRepository.findById(id).get();
    }

    public List<ProdutoImagens> buscarTodos() {
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserir(Long produtoId, MultipartFile file) {
        Produto produto = produtoRepository.findById(produtoId).get();
        ProdutoImagens obj = new ProdutoImagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("/home/nicholasboari/imagens/" + nomeImagem);
                Files.write(caminho, bytes);
                obj.setNome(nomeImagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        obj.setProduto(produto);
        obj.setDataCriacao(new Date());
        obj = produtoImagensRepository.saveAndFlush(obj);
        return obj;
    }

    public ProdutoImagens alterar(ProdutoImagens obj) {
        obj.setDataAtualizacao(new Date());
        return produtoImagensRepository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        ProdutoImagens produtoImagens = produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(produtoImagens);
    }
}
