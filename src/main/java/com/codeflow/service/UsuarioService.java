package com.codeflow.service;

import java.util.List;

import com.codeflow.dto.UsuarioDTO;

/**
 * Serviço de usuarios.
 */
public interface UsuarioService {

	/**
	 * Buscar todos os usuarios.
	 * 
	 * @return lista de usuario dto.
	 */
	public List<UsuarioDTO> getAllUsuario();
	
	

	/**
	 * Adicionar novo usuario.
	 * 
	 * @param usuarioDTO dto de usuario
	 * @return lista de usuario dto.
	 */
	public UsuarioDTO postUsuario(UsuarioDTO usuarioDTO);
	

	/**
	 * EditarUsuario
	 * 
	 * @return lista de usuario dto.
	 */
	public UsuarioDTO putUsuario(UsuarioDTO usuarioDTO);

	/**
	 * EditarUsuario
	 * 
	 * @param id id do usuario a ser excluido.
	 */
	public void deleteUsuario(Long id);

	/**
	 * Buscar Usuario pelo id.
	 * 
	 * @param id id do usuario
	 * @return usuario encontrado
	 */
	public UsuarioDTO getByIdUsuario(Long id);

}
