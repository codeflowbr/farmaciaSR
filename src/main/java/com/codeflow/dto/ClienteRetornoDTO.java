
package com.codeflow.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ClienteRetornoDTO {

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("vendas")
	private List<String> vendas;

	@JsonProperty("quadroClinico")
	private List<String> quadroClinico;

	@JsonProperty("telefone")
	private String telefone;

}
