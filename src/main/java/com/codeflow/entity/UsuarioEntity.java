package com.codeflow.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity(name = "usuario")
@Data
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceUsuarioId")
	@SequenceGenerator(name = "SequenceUsuarioId", sequenceName = "USUARIO_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "senha")
	private String senha;
	
}
