package com.codeflow.utils;

import java.util.ArrayList;
import java.util.List;

import com.codeflow.dto.ClienteDTO;
import com.codeflow.entity.ClienteEntity;
import com.google.gson.Gson;

/**
 * Classe responsavel pelos conversores de Entidades e DTOs de cliente.
 */
public abstract class ClienteUtils {

	/**
	 * ConverterDTOEmEntidade sem perder os dados.
	 * 
	 * @param clienteDTO
	 * @return entidade de carros
	 */
	public static ClienteEntity convertDTOemEntity(final ClienteDTO clienteDTO) {
		final Gson gson = new Gson();
		final String tmp = gson.toJson(clienteDTO);
		return gson.fromJson(tmp, ClienteEntity.class);
	}

	/**
	 * convertEntityemDTO sem perder os dados.
	 * 
	 * @param clienteEntity
	 * @return entidade de carros
	 */
	public static ClienteDTO convertEntityemDTO(final ClienteEntity clienteEntity) {
		final Gson gson = new Gson();
		final String tmp = gson.toJson(clienteEntity);
		return gson.fromJson(tmp, ClienteDTO.class);
	}

	/**
	 * converter lista de dto em lista entity.
	 * 
	 * @param listDTO lista de dtos
	 * @return lista de entidades.
	 */
	public static List<ClienteEntity> convertDTOListInEntityList(final List<ClienteDTO> listDTO) {
		final List<ClienteEntity> clienteEntityList = new ArrayList<>();
		for (final ClienteDTO ClienteDTO : listDTO) {
			final ClienteEntity clienteEntity = convertDTOemEntity(ClienteDTO);
			clienteEntityList.add(clienteEntity);
		}
		return clienteEntityList;
	}

	/**
	 * converter lista de entidade em lista dto.
	 * 
	 * @param listEntity lista de entidades
	 * @return lista de dtos.
	 */
	public static List<ClienteDTO> convertEntityListInDTOList(final List<ClienteEntity> listEntity) {
		final List<ClienteDTO> clienteDTOList = new ArrayList<>();
		for (final ClienteEntity ClienteEntity : listEntity) {
			clienteDTOList.add(convertEntityemDTO(ClienteEntity));
		}
		return clienteDTOList;
	}

}