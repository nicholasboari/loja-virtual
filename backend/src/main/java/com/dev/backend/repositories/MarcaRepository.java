package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
