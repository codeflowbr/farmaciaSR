package com.codeflow.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity(name = "cliente")
@Data
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceClienteId")
	@SequenceGenerator(name = "SequenceClienteId", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "endereço")
	private String endereco;
	
	@ManyToMany
	@JoinTable(name = "doenca_cliente", joinColumns = @JoinColumn(name = "doenca_id"), inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	private List<DoencaEntity> doencas  = new ArrayList<>();;
	
}
