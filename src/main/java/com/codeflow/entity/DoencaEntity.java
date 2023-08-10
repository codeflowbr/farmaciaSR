package com.codeflow.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity(name = "doenca")
@Data
public class DoencaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceDoencaId")
	@SequenceGenerator(name = "SequenceDoencaId", sequenceName = "DOENCA_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "doenca")
	private String doenca;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "doenca_produto", joinColumns = @JoinColumn(name = "doenca_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<ProdutoEntity> produtos;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "doenca_cliente", joinColumns = @JoinColumn(name = "doenca_id"), inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	private List<ClienteEntity> clientes;
	
}
