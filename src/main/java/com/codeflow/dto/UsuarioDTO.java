package com.codeflow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UsuarioDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty( "nome")
	private String nome;

	@JsonProperty( "telefone")
	private String telefone;
	
	@JsonProperty( "cpf")
	private String cpf;
	
	@JsonProperty( "login")
	private String login;
	
	@JsonProperty( "senha")
	private String senha;

}
