package com.dev.backend.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String descricaoCurta;
  private String descricaoDetalhada;
  private Double valorCusto;
  private Double valorVenda;

  @ManyToOne
  @JoinColumn(name = "marca_id")
  private Marca marca;

  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private Categoria categoria;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataAtualizacao;
}
