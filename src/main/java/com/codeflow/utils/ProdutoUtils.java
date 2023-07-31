package com.codeflow.utils;

import java.util.ArrayList;
import java.util.List;

import com.codeflow.dto.ProdutoDTO;
import com.codeflow.entity.ProdutoEntity;
import com.google.gson.Gson;

/**
 * Classe responsavel pelos conversores de Entidades e DTOs de produto.
 */
public abstract class ProdutoUtils {

	/**
	 * ConverterDTOEmEntidade sem perder os dados.
	 * 
	 * @param produtoDTO
	 * @return entidade de carros
	 */
	public static ProdutoEntity convertDTOemEntity(final ProdutoDTO produtoDTO) {
		final Gson gson = new Gson();
		final String tmp = gson.toJson(produtoDTO);
		return gson.fromJson(tmp, ProdutoEntity.class);
	}

	/**
	 * convertEntityemDTO sem perder os dados.
	 * 
	 * @param produtoEntity
	 * @return entidade de carros
	 */
	public static ProdutoDTO convertEntityemDTO(final ProdutoEntity produtoEntity) {
		final Gson gson = new Gson();
		final String tmp = gson.toJson(produtoEntity);
		return gson.fromJson(tmp, ProdutoDTO.class);
	}

	/**
	 * converter lista de dto em lista entity.
	 * 
	 * @param listDTO lista de dtos
	 * @return lista de entidades.
	 */
	public static List<ProdutoEntity> convertDTOListInEntityList(final List<ProdutoDTO> listDTO) {
		final List<ProdutoEntity> produtoEntityList = new ArrayList<>();
		for (final ProdutoDTO ProdutoDTO : listDTO) {
			final ProdutoEntity produtoEntity = convertDTOemEntity(ProdutoDTO);
			produtoEntityList.add(produtoEntity);
		}
		return produtoEntityList;
	}

	/**
	 * converter lista de entidade em lista dto.
	 * 
	 * @param listEntity lista de entidades
	 * @return lista de dtos.
	 */
	public static List<ProdutoDTO> convertEntityListInDTOList(final List<ProdutoEntity> listEntity) {
		final List<ProdutoDTO> produtoDTOList = new ArrayList<>();
		for (final ProdutoEntity ProdutoEntity : listEntity) {
			produtoDTOList.add(convertEntityemDTO(ProdutoEntity));
		}
		return produtoDTOList;
	}

}