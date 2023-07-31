package com.codeflow.dto;

import java.util.List;


import com.codeflow.entity.DoencaEntity;
import com.codeflow.entity.ProdutoEntity;
import com.codeflow.entity.VendaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class DoencaDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("doenca")
	private String doenca;

	@JsonProperty("produtos")
	private List<ProdutoEntity> produtos;
}
