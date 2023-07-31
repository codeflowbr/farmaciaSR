package com.codeflow.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codeflow.dto.DoencaDTO;
import com.codeflow.entity.DoencaEntity;
import com.codeflow.repository.DoencaRepository;
import com.codeflow.service.DoencaService;
import com.codeflow.utils.DoencaUtils;

@Service
public class DoencaServiceImpl implements DoencaService {
	

	@Autowired
	private DoencaRepository doencaRepository;
	

	@Override
	public List<DoencaDTO> getAllDoenca() {
		List<DoencaEntity> listDoencaEntity = doencaRepository.findAll();
		return DoencaUtils.convertEntityListInDTOList(listDoencaEntity);
	}

	@Override
	public DoencaDTO postDoenca(DoencaDTO doencaDTO) {
		DoencaEntity doencaEntity = DoencaUtils.convertDTOemEntity(doencaDTO);
		DoencaEntity doencaEntityreturn = doencaRepository.saveAndFlush(doencaEntity);
		return DoencaUtils.convertEntityemDTO(doencaEntityreturn);
	}

	@Override
	public DoencaDTO putDoenca(DoencaDTO doencaDTO) {
		getByIdDoenca(doencaDTO.getId());
		DoencaEntity doencaEntity = doencaRepository.save(DoencaUtils.convertDTOemEntity(doencaDTO));
		return DoencaUtils.convertEntityemDTO(doencaEntity);
	}

	@Override
	public void deleteDoenca(Long id) {
		getByIdDoenca(id);
		doencaRepository.deleteById(id);
	}

	@Override
	public DoencaDTO getByIdDoenca(Long id) {
		Optional<DoencaEntity> doencaEntity = doencaRepository.findById(id);
		if (doencaEntity.isPresent()) {
			return DoencaUtils.convertEntityemDTO(doencaEntity.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doenca não encontrado");
	}

}
