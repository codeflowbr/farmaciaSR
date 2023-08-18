package com.codeflow.service;

import java.util.List;

import com.codeflow.dto.ClienteDTO;
import com.codeflow.dto.ClienteRetornoDTO;
import com.codeflow.entity.ClienteEntity;

/**
 * Serviço de clientes.
 */
public interface ClienteService {

	/**
	 * Buscar todos os clientes.
	 * 
	 * @return lista de cliente dto.
	 */
	public List<ClienteEntity> getAllCliente();
	
	

	/**
	 * Adicionar novo cliente.
	 * 
	 * @param clienteDTO dto de cliente
	 * @return lista de cliente dto.
	 */
	public ClienteEntity postCliente(ClienteDTO clienteDTO);
	

	/**
	 * EditarCliente
	 * 
	 * @return lista de cliente dto.
	 */
	public ClienteEntity putCliente(ClienteDTO clienteDTO);

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
	public ClienteEntity getByIdCliente(Long id);


	/**
	 * buscar todos os clientes apartir de uma letra.
	 * @param nome
	 * @return lista de clientes
	 */
	public List<ClienteEntity> getAllClienteiLike(String nome);

	public ClienteRetornoDTO getDadosByIdCliente(Long id);

}
