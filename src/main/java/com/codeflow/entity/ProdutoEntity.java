package com.codeflow.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity(name = "produto")
@Data
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceProdutoId")
	@SequenceGenerator(name = "SequenceProdutoId", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "desconto")
	private Integer desconto;

	@Nullable
	@JsonBackReference
	@ManyToMany(mappedBy = "produtos")
    private List<VendaEntity> vendas;

	@Nullable
	@JsonBackReference
	@ManyToMany(mappedBy = "produtos")
    private List<DoencaEntity> doencas;
	
}
