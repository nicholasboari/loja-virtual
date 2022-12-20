package com.dev.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "produto_imagens")
@Data
public class ProdutoImagens {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;

  @ManyToOne()
  @JoinColumn(name = "produto_id")
  private Produto produto;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataAtualizacao;
}
