package com.codeflow.service;

import java.util.List;

import com.codeflow.dto.VendaDTO;

/**
 * Serviço de vendas.
 */
public interface VendaService {

	/**
	 * Buscar todos os vendas.
	 * 
	 * @return lista de venda dto.
	 */
	public List<VendaDTO> getAllVenda();
	
	

	/**
	 * Adicionar novo venda.
	 * 
	 * @param vendaDTO dto de venda
	 * @return lista de venda dto.
	 */
	public VendaDTO postVenda(VendaDTO vendaDTO);
	

	/**
	 * EditarVenda
	 * 
	 * @return lista de venda dto.
	 */
	public VendaDTO putVenda(VendaDTO vendaDTO);

	/**
	 * EditarVenda
	 * 
	 * @param id id do venda a ser excluido.
	 */
	public void deleteVenda(Long id);

	/**
	 * Buscar Venda pelo id.
	 * 
	 * @param id id do venda
	 * @return venda encontrado
	 */
	public VendaDTO getByIdVenda(Long id);

}
