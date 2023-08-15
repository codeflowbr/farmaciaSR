package com.codeflow.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codeflow.dto.ClienteDTO;
import com.codeflow.entity.ClienteEntity;
import com.codeflow.entity.DoencaEntity;
import com.codeflow.entity.ProdutoEntity;
import com.codeflow.repository.ClienteRepository;
import com.codeflow.repository.DoencaRepository;
import com.codeflow.service.ClienteService;
import com.codeflow.utils.ClienteUtils;

@Service
public class ClienteServiceImpl implements ClienteService {
	

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private DoencaRepository doencaRepository;
	

	@Override
	public List<ClienteEntity> getAllCliente() {
		List<ClienteEntity> listClienteEntity = clienteRepository.findAll();
		return listClienteEntity;
	}

	@Override
	public ClienteEntity postCliente(ClienteDTO clienteDTO) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setDataCadastro(new Date());
		clienteEntity.setCpf(clienteDTO.getCpf());
		clienteEntity.setEndereco(clienteDTO.getEndereco());
		clienteEntity.setGenero(clienteDTO.getGenero());
		clienteEntity.setNome(clienteDTO.getNome());
		clienteEntity.setTelefone(clienteDTO.getTelefone());
		clienteEntity.setDoencas(new ArrayList());
		for (Long doencaEntity : clienteDTO.getDoencas()) {
			DoencaEntity doenca = doencaRepository.findById(doencaEntity).orElse(null);
			  if (doenca != null) {
				  clienteEntity.getDoencas().add(doenca);
              }
		}
		
		return clienteRepository.saveAndFlush(clienteEntity);
	}

	@Override
	public ClienteEntity putCliente(ClienteDTO clienteDTO) {
		ClienteEntity clienteEntity = getByIdCliente(clienteDTO.getId());
		clienteEntity.setCpf(clienteDTO.getCpf());
		clienteEntity.setEndereco(clienteDTO.getEndereco());
		clienteEntity.setGenero(clienteDTO.getGenero());
		clienteEntity.setNome(clienteDTO.getNome());
		clienteEntity.setTelefone(clienteDTO.getTelefone());
		clienteEntity.setDoencas(new ArrayList());
		for (Long doencaEntity : clienteDTO.getDoencas()) {
			DoencaEntity doenca = doencaRepository.findById(doencaEntity).orElse(null);
			  if (doenca != null) {
				  clienteEntity.getDoencas().add(doenca);
              }
		}
		ClienteEntity clienteEntityreturn = clienteRepository.save(clienteEntity);
		return clienteEntityreturn;
	}

	@Override
	public void deleteCliente(Long id) {
		getByIdCliente(id);
		clienteRepository.deleteById(id);
	}

	@Override
	public ClienteEntity getByIdCliente(Long id) {
		Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
		if (clienteEntity.isPresent()) {
			return clienteEntity.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
	}

	@Override
	public List<ClienteEntity> getAllClienteiLike(String nome) {
		List<ClienteEntity> listClienteEntity = clienteRepository.findByNomeIgnoreCaseContaining(nome);
		return listClienteEntity;
	}

}
