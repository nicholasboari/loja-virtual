package com.dev.backend.repositories;

import com.dev.backend.entities.ProdutoImagens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long> {
}
