package com.codeflow.dto;

import java.util.ArrayList;
import java.util.List;


import com.codeflow.entity.DoencaEntity;
import com.codeflow.entity.VendaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class DashboardDTO {

	@JsonProperty( "totalMsg")
	private Long totalMsg;

	@JsonProperty( "totalCli")
	private Long totalCli;
	
	@JsonProperty( "totalProd")
	private Long totalProd;

	@JsonProperty( "totalValor")
	private Double totalValor;

	@JsonProperty( "totalRevenda")
	private Long totalRevenda;
	
	@JsonProperty( "produtoMaisVendido")
	private Long produtoMaisVendido;
	
	@JsonProperty("clienteMensal")
	private List<ClienteMensalDTO> clienteMensal;

	@JsonProperty("mensagemMensal")
	private List<MensagemMensalDTO> mensagemMensal;

	
}
