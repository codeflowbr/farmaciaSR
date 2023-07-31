package com.codeflow.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codeflow.dto.VendaDTO;
import com.codeflow.entity.VendaEntity;
import com.codeflow.repository.VendaRepository;
import com.codeflow.service.VendaService;
import com.codeflow.utils.VendaUtils;

@Service
public class VendaServiceImpl implements VendaService {
	

	@Autowired
	private VendaRepository vendaRepository;
	

	@Override
	public List<VendaDTO> getAllVenda() {
		List<VendaEntity> listVendaEntity = vendaRepository.findAll();
		return VendaUtils.convertEntityListInDTOList(listVendaEntity);
	}

	@Override
	public VendaDTO postVenda(VendaDTO vendaDTO) {
		VendaEntity vendaEntity = VendaUtils.convertDTOemEntity(vendaDTO);
		VendaEntity vendaEntityreturn = vendaRepository.saveAndFlush(vendaEntity);
		return VendaUtils.convertEntityemDTO(vendaEntityreturn);
	}

	@Override
	public VendaDTO putVenda(VendaDTO vendaDTO) {
		getByIdVenda(vendaDTO.getId());
		VendaEntity vendaEntity = vendaRepository.save(VendaUtils.convertDTOemEntity(vendaDTO));
		return VendaUtils.convertEntityemDTO(vendaEntity);
	}

	@Override
	public void deleteVenda(Long id) {
		getByIdVenda(id);
		vendaRepository.deleteById(id);
	}

	@Override
	public VendaDTO getByIdVenda(Long id) {
		Optional<VendaEntity> vendaEntity = vendaRepository.findById(id);
		if (vendaEntity.isPresent()) {
			return VendaUtils.convertEntityemDTO(vendaEntity.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrado");
	}

}
