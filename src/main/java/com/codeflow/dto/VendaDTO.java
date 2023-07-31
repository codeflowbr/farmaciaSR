package com.codeflow.dto;

import java.util.Date;
import java.util.List;


import com.codeflow.entity.ClienteEntity;
import com.codeflow.entity.ProdutoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	private List<ProdutoEntity> produtos;

	@JsonProperty("cliente")
    private ClienteEntity cliente;

}
