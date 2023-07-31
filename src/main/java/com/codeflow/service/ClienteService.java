package com.codeflow.service;

import java.util.List;

import com.codeflow.dto.ClienteDTO;

/**
 * Serviço de clientes.
 */
public interface ClienteService {

	/**
	 * Buscar todos os clientes.
	 * 
	 * @return lista de cliente dto.
	 */
	public List<ClienteDTO> getAllCliente();
	
	

	/**
	 * Adicionar novo cliente.
	 * 
	 * @param clienteDTO dto de cliente
	 * @return lista de cliente dto.
	 */
	public ClienteDTO postCliente(ClienteDTO clienteDTO);
	

	/**
	 * EditarCliente
	 * 
	 * @return lista de cliente dto.
	 */
	public ClienteDTO putCliente(ClienteDTO clienteDTO);

	/**
	 * EditarCliente
	 * 
	 * @param id id do cliente a ser excluido.
	 */
	public void deleteCliente(Long id);

	/**
	 * Buscar Cliente pelo id.
	 * 
	 * @param id id do cliente
	 * @return cliente encontrado
	 */
	public ClienteDTO getByIdCliente(Long id);

}
