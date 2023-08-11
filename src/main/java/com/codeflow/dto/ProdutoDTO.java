package com.codeflow.dto;

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
	private Integer desconto;

	@Nullable
	@JsonProperty("doencas")
    private List<Long> doencas;

}
