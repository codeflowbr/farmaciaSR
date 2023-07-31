package com.codeflow.service;

import java.util.List;

import com.codeflow.dto.DoencaDTO;

/**
 * Serviço de doencas.
 */
public interface DoencaService {

	/**
	 * Buscar todos os doencas.
	 * 
	 * @return lista de doenca dto.
	 */
	public List<DoencaDTO> getAllDoenca();
	
	

	/**
	 * Adicionar novo doenca.
	 * 
	 * @param doencaDTO dto de doenca
	 * @return lista de doenca dto.
	 */
	public DoencaDTO postDoenca(DoencaDTO doencaDTO);
	

	/**
	 * EditarDoenca
	 * 
	 * @return lista de doenca dto.
	 */
	public DoencaDTO putDoenca(DoencaDTO doencaDTO);

	/**
	 * EditarDoenca
	 * 
	 * @param id id do doenca a ser excluido.
	 */
	public void deleteDoenca(Long id);

	/**
	 * Buscar Doenca pelo id.
	 * 
	 * @param id id do doenca
	 * @return doenca encontrado
	 */
	public DoencaDTO getByIdDoenca(Long id);

}
