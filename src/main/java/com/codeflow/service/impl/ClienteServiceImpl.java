package com.codeflow.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codeflow.dto.ClienteDTO;
import com.codeflow.entity.ClienteEntity;
import com.codeflow.repository.ClienteRepository;
import com.codeflow.service.ClienteService;
import com.codeflow.utils.ClienteUtils;

@Service
public class ClienteServiceImpl implements ClienteService {
	

	@Autowired
	private ClienteRepository clienteRepository;
	

	@Override
	public List<ClienteDTO> getAllCliente() {
		List<ClienteEntity> listClienteEntity = clienteRepository.findAll();
		return ClienteUtils.convertEntityListInDTOList(listClienteEntity);
	}

	@Override
	public ClienteDTO postCliente(ClienteDTO clienteDTO) {
		ClienteEntity clienteEntity = ClienteUtils.convertDTOemEntity(clienteDTO);
		ClienteEntity clienteEntityreturn = clienteRepository.saveAndFlush(clienteEntity);
		return ClienteUtils.convertEntityemDTO(clienteEntityreturn);
	}

	@Override
	public ClienteDTO putCliente(ClienteDTO clienteDTO) {
		getByIdCliente(clienteDTO.getId());
		ClienteEntity clienteEntity = clienteRepository.save(ClienteUtils.convertDTOemEntity(clienteDTO));
		return ClienteUtils.convertEntityemDTO(clienteEntity);
	}

	@Override
	public void deleteCliente(Long id) {
		getByIdCliente(id);
		clienteRepository.deleteById(id);
	}

	@Override
	public ClienteDTO getByIdCliente(Long id) {
		Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
		if (clienteEntity.isPresent()) {
			return ClienteUtils.convertEntityemDTO(clienteEntity.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
	}

}
