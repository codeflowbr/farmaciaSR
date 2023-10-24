package com.codeflow.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity(name = "venda")
@Data
public class VendaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceVendaId")
	@SequenceGenerator(name = "SequenceVendaId", sequenceName = "VENDA_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "duracao")
	private Integer duracao;
	
	@Column(name = "mensagemEnviada", columnDefinition = "boolean default false")
	private Boolean mensagemEnviada= false;


	@Column(name = "isRevenda", columnDefinition = "boolean default false")
	private Boolean revenda = false;
	
	@Column(name = "recorrente")
	private Boolean recorrente;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "venda")
	private Date venda;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dataMensagem")
	private Date dataMensagem;

	
	@ManyToMany
	@JoinTable(name = "venda_produto", joinColumns = @JoinColumn(name = "venda_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<ProdutoEntity> produtos  = new ArrayList<>();

	
	@ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
	
}
