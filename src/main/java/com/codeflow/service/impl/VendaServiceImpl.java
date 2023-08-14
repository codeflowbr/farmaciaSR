package com.codeflow.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codeflow.dto.VendaDTO;
import com.codeflow.entity.ProdutoEntity;
import com.codeflow.entity.VendaEntity;
import com.codeflow.repository.ClienteRepository;
import com.codeflow.repository.ProdutoRepository;
import com.codeflow.repository.VendaRepository;
import com.codeflow.service.VendaService;
import com.codeflow.utils.VendaUtils;
import java.util.Calendar;

@Service
public class VendaServiceImpl implements VendaService {
	

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	

	@Override
	public List<VendaEntity> getAllVenda() {
		List<VendaEntity> listVendaEntity = vendaRepository.findAll();
		return listVendaEntity;
	}

	@Override
	public VendaEntity postVenda(VendaDTO vendaDTO) {
		VendaEntity vendaEntity = new VendaEntity();
		vendaEntity.setCliente(clienteRepository.findById(vendaDTO.getCliente()).orElse(null));
		vendaEntity.setDuracao(vendaDTO.getDuracao());
		vendaEntity.setRecorrente(vendaDTO.getRecorrente());
		vendaEntity.setMensagemEnviada(false);
		vendaEntity.setVenda(vendaDTO.getVenda());
		
		 Calendar calendar = Calendar.getInstance();
		 calendar.add(Calendar.DAY_OF_MONTH, vendaEntity.getDuracao() - 5);
		vendaEntity.setDataMensagem(calendar.getTime());
		
		for (Long produtoEntity : vendaDTO.getProdutos()) {
			ProdutoEntity produto= produtoRepository.findById(produtoEntity).orElse(null);
			  if (produto != null) {
				  vendaEntity.getProdutos().add(produto);
	          }
		}
		
		VendaEntity vendaEntityreturn = vendaRepository.saveAndFlush(vendaEntity);
		return vendaEntityreturn;
	}

	@Override
	public VendaEntity putVenda(VendaDTO vendaDTO) {
		getByIdVenda(vendaDTO.getId());
		VendaEntity vendaEntity = vendaRepository.save(VendaUtils.convertDTOemEntity(vendaDTO));
		return vendaEntity;
	}

	@Override
	public void deleteVenda(Long id) {
		getByIdVenda(id);
		vendaRepository.deleteById(id);
	}

	@Override
	public VendaEntity getByIdVenda(Long id) {
		Optional<VendaEntity> vendaEntity = vendaRepository.findById(id);
		if (vendaEntity.isPresent()) {
			return vendaEntity.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrado");
	}

}
