package com.codeflow.utils;

import java.util.ArrayList;
import java.util.List;

import com.codeflow.dto.UsuarioDTO;
import com.codeflow.entity.UsuarioEntity;
import com.google.gson.Gson;

/**
 * Classe responsavel pelos conversores de Entidades e DTOs de usuario.
 */
public abstract class UsuarioUtils {

	/**
	 * ConverterDTOEmEntidade sem perder os dados.
	 * 
	 * @param usuarioDTO
	 * @return entidade de carros
	 */
	public static UsuarioEntity convertDTOemEntity(final UsuarioDTO usuarioDTO) {
		final Gson gson = new Gson();
		final String tmp = gson.toJson(usuarioDTO);
		return gson.fromJson(tmp, UsuarioEntity.class);
	}

	/**
	 * convertEntityemDTO sem perder os dados.
	 * 
	 * @param usuarioEntity
	 * @return entidade de carros
	 */
	public static UsuarioDTO convertEntityemDTO(final UsuarioEntity usuarioEntity) {
		final Gson gson = new Gson();
		final String tmp = gson.toJson(usuarioEntity);
		return gson.fromJson(tmp, UsuarioDTO.class);
	}

	/**
	 * converter lista de dto em lista entity.
	 * 
	 * @param listDTO lista de dtos
	 * @return lista de entidades.
	 */
	public static List<UsuarioEntity> convertDTOListInEntityList(final List<UsuarioDTO> listDTO) {
		final List<UsuarioEntity> usuarioEntityList = new ArrayList<>();
		for (final UsuarioDTO UsuarioDTO : listDTO) {
			final UsuarioEntity usuarioEntity = convertDTOemEntity(UsuarioDTO);
			usuarioEntityList.add(usuarioEntity);
		}
		return usuarioEntityList;
	}

	/**
	 * converter lista de entidade em lista dto.
	 * 
	 * @param listEntity lista de entidades
	 * @return lista de dtos.
	 */
	public static List<UsuarioDTO> convertEntityListInDTOList(final List<UsuarioEntity> listEntity) {
		final List<UsuarioDTO> usuarioDTOList = new ArrayList<>();
		for (final UsuarioEntity UsuarioEntity : listEntity) {
			usuarioDTOList.add(convertEntityemDTO(UsuarioEntity));
		}
		return usuarioDTOList;
	}

}