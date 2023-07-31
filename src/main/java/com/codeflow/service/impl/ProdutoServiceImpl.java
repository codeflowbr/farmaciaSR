package com.codeflow.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codeflow.dto.ProdutoDTO;
import com.codeflow.entity.ProdutoEntity;
import com.codeflow.repository.ProdutoRepository;
import com.codeflow.service.ProdutoService;
import com.codeflow.utils.ProdutoUtils;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	

	@Autowired
	private ProdutoRepository produtoRepository;
	

	@Override
	public List<ProdutoDTO> getAllProduto() {
		List<ProdutoEntity> listProdutoEntity = produtoRepository.findAll();
		return ProdutoUtils.convertEntityListInDTOList(listProdutoEntity);
	}

	@Override
	public ProdutoDTO postProduto(ProdutoDTO produtoDTO) {
		ProdutoEntity produtoEntity = ProdutoUtils.convertDTOemEntity(produtoDTO);
		ProdutoEntity produtoEntityreturn = produtoRepository.saveAndFlush(produtoEntity);
		return ProdutoUtils.convertEntityemDTO(produtoEntityreturn);
	}

	@Override
	public ProdutoDTO putProduto(ProdutoDTO produtoDTO) {
		getByIdProduto(produtoDTO.getId());
		ProdutoEntity produtoEntity = produtoRepository.save(ProdutoUtils.convertDTOemEntity(produtoDTO));
		return ProdutoUtils.convertEntityemDTO(produtoEntity);
	}

	@Override
	public void deleteProduto(Long id) {
		getByIdProduto(id);
		produtoRepository.deleteById(id);
	}

	@Override
	public ProdutoDTO getByIdProduto(Long id) {
		Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
		if (produtoEntity.isPresent()) {
			return ProdutoUtils.convertEntityemDTO(produtoEntity.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
	}

}
