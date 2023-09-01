package com.codeflow.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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

	@Column(name = "valor")
	private Float valor;
	
	@Column(name = "desconto")
	private Float desconto;

	@ManyToMany
	@JoinTable(name = "doenca_produto", joinColumns = @JoinColumn(name = "doenca_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<DoencaEntity> doencas = new ArrayList<>();
	
	
}
