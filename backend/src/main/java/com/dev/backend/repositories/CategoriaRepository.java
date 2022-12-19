package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
