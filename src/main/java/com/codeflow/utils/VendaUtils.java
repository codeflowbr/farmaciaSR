package com.codeflow.utils;

import java.util.ArrayList;
import java.util.List;

import com.codeflow.dto.VendaDTO;
import com.codeflow.entity.VendaEntity;
import com.google.gson.Gson;

/**
 * Classe responsavel pelos conversores de Entidades e DTOs de venda.
 */
public abstract class VendaUtils {

	/**
	 * ConverterDTOEmEntidade sem perder os dados.
	 * 
	 * @param vendaDTO
	 * @return entidade de carros
	 */
	public static VendaEntity convertDTOemEntity(final VendaDTO vendaDTO) {
		final Gson gson = new Gson();
		final String tmp = gson.toJson(vendaDTO);
		return gson.fromJson(tmp, VendaEntity.class);
	}

	/**
	 * convertEntityemDTO sem perder os dados.
	 * 
	 * @param vendaEntity
	 * @return entidade de carros
	 */
	public static VendaDTO convertEntityemDTO(final VendaEntity vendaEntity) {
		final Gson gson = new Gson();
		final String tmp = gson.toJson(vendaEntity);
		return gson.fromJson(tmp, VendaDTO.class);
	}

	/**
	 * converter lista de dto em lista entity.
	 * 
	 * @param listDTO lista de dtos
	 * @return lista de entidades.
	 */
	public static List<VendaEntity> convertDTOListInEntityList(final List<VendaDTO> listDTO) {
		final List<VendaEntity> vendaEntityList = new ArrayList<>();
		for (final VendaDTO VendaDTO : listDTO) {
			final VendaEntity vendaEntity = convertDTOemEntity(VendaDTO);
			vendaEntityList.add(vendaEntity);
		}
		return vendaEntityList;
	}

	/**
	 * converter lista de entidade em lista dto.
	 * 
	 * @param listEntity lista de entidades
	 * @return lista de dtos.
	 */
	public static List<VendaDTO> convertEntityListInDTOList(final List<VendaEntity> listEntity) {
		final List<VendaDTO> vendaDTOList = new ArrayList<>();
		for (final VendaEntity VendaEntity : listEntity) {
			vendaDTOList.add(convertEntityemDTO(VendaEntity));
		}
		return vendaDTOList;
	}

}