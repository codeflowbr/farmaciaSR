package com.codeflow.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.micrometer.common.lang.Nullable;
import lombok.Data;

@Data
public class ClienteMensalDTO {

	@JsonProperty("mes")
	private int mes;
	
	@JsonProperty("ano")
	private int ano;
	
	@JsonProperty("valor")
	private BigDecimal valor;

}
