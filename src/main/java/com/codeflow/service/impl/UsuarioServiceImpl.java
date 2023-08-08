package com.codeflow.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codeflow.dto.LoginDTO;
import com.codeflow.dto.UsuarioDTO;
import com.codeflow.entity.UsuarioEntity;
import com.codeflow.repository.UsuarioRepository;
import com.codeflow.service.UsuarioService;
import com.codeflow.utils.UsuarioUtils;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	

	@Autowired
	private UsuarioRepository usuarioRepository;
	

	@Override
	public List<UsuarioDTO> getAllUsuario() {
		List<UsuarioEntity> listUsuarioEntity = usuarioRepository.findAll();
		return UsuarioUtils.convertEntityListInDTOList(listUsuarioEntity);
	}

	@Override
	public UsuarioDTO postUsuario(UsuarioDTO usuarioDTO) {
		UsuarioEntity usuarioEntity = UsuarioUtils.convertDTOemEntity(usuarioDTO);
		UsuarioEntity usuarioEntityreturn = usuarioRepository.saveAndFlush(usuarioEntity);
		return UsuarioUtils.convertEntityemDTO(usuarioEntityreturn);
	}

	@Override
	public UsuarioDTO putUsuario(UsuarioDTO usuarioDTO) {
		getByIdUsuario(usuarioDTO.getId());
		UsuarioEntity usuarioEntity = usuarioRepository.save(UsuarioUtils.convertDTOemEntity(usuarioDTO));
		return UsuarioUtils.convertEntityemDTO(usuarioEntity);
	}

	@Override
	public void deleteUsuario(Long id) {
		getByIdUsuario(id);
		usuarioRepository.deleteById(id);
	}

	@Override
	public UsuarioDTO getByIdUsuario(Long id) {
		Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
		if (usuarioEntity.isPresent()) {
			return UsuarioUtils.convertEntityemDTO(usuarioEntity.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado");
	}


	@Override
	public UsuarioDTO getLogin(LoginDTO login) {
		Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findByLoginAndSenha(login.getLogin(), login.getPassword());
		if (usuarioEntity.isPresent()) {
			return UsuarioUtils.convertEntityemDTO(usuarioEntity.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer não encontrado");
	}
	
}
