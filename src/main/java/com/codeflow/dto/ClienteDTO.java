package com.codeflow.dto;

import java.util.List;


import com.codeflow.entity.DoencaEntity;
import com.codeflow.entity.VendaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class ClienteDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty( "nome")
	private String nome;

	@JsonProperty( "telefone")
	private String telefone;
	
	@JsonProperty( "cpf")
	private String cpf;
	
	@JsonProperty( "venda")
    private List<VendaEntity> vendas;

}
