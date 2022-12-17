package com.dev.backend.entities;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  private String cpf;
  private String email;
  private String endereco;
  private String cep;

  @OneToOne
  @Nonnull
  private Cidade cidade;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataAtualizacao;
}