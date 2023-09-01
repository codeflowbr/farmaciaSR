package com.codeflow.dto;

import java.util.ArrayList;
import java.util.List;


import com.codeflow.entity.DoencaEntity;
import com.codeflow.entity.VendaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class ProdutoDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("desconto")
	private Float desconto;
	
	@JsonProperty("valor")
	private Float valor;

	@Nullable
	@JsonProperty("doencas")
    private List<Long> doencas = new ArrayList<>();

}
