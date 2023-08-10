package com.codeflow.dto;

import java.util.Date;
import java.util.List;


import com.codeflow.entity.ClienteEntity;
import com.codeflow.entity.ProdutoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class VendaDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("duracao")
	private Integer duracao;

	@JsonProperty("venda")
	private Date venda;

	@JsonProperty("produtos")
	private List<ProdutoDTO> produtos;

	@JsonProperty("recorrente")
	private Boolean recorrente;
	
	@JsonProperty("cliente")
    private ClienteDTO cliente;

}
