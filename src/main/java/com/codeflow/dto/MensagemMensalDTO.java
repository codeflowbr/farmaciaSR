package com.codeflow.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.micrometer.common.lang.Nullable;
import lombok.Data;

@Data
public class MensagemMensalDTO {

	@JsonProperty("x")
	private int x;
	
	@JsonProperty("y")
	private BigDecimal y;

}
