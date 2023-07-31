package com.codeflow.utils;

import java.util.ArrayList;
import java.util.List;

import com.codeflow.dto.DoencaDTO;
import com.codeflow.entity.DoencaEntity;
import com.google.gson.Gson;

/**
 * Classe responsavel pelos conversores de Entidades e DTOs de doenca.
 */
public abstract class DoencaUtils {

	/**
	 * ConverterDTOEmEntidade sem perder os dados.
	 * 
	 * @param doencaDTO
	 * @return entidade de carros
	 */
	public static DoencaEntity convertDTOemEntity(final DoencaDTO doencaDTO) {
		final Gson gson = new Gson();
		final String tmp = gson.toJson(doencaDTO);
		return gson.fromJson(tmp, DoencaEntity.class);
	}

	/**
	 * convertEntityemDTO sem perder os dados.
	 * 
	 * @param doencaEntity
	 * @return entidade de carros
	 */
	public static DoencaDTO convertEntityemDTO(final DoencaEntity doencaEntity) {
		final Gson gson = new Gson();
		final String tmp = gson.toJson(doencaEntity);
		return gson.fromJson(tmp, DoencaDTO.class);
	}

	/**
	 * converter lista de dto em lista entity.
	 * 
	 * @param listDTO lista de dtos
	 * @return lista de entidades.
	 */
	public static List<DoencaEntity> convertDTOListInEntityList(final List<DoencaDTO> listDTO) {
		final List<DoencaEntity> doencaEntityList = new ArrayList<>();
		for (final DoencaDTO DoencaDTO : listDTO) {
			final DoencaEntity doencaEntity = convertDTOemEntity(DoencaDTO);
			doencaEntityList.add(doencaEntity);
		}
		return doencaEntityList;
	}

	/**
	 * converter lista de entidade em lista dto.
	 * 
	 * @param listEntity lista de entidades
	 * @return lista de dtos.
	 */
	public static List<DoencaDTO> convertEntityListInDTOList(final List<DoencaEntity> listEntity) {
		final List<DoencaDTO> doencaDTOList = new ArrayList<>();
		for (final DoencaEntity DoencaEntity : listEntity) {
			doencaDTOList.add(convertEntityemDTO(DoencaEntity));
		}
		return doencaDTOList;
	}

}