package com.codeflow.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codeflow.dto.ProdutoDTO;
import com.codeflow.entity.DoencaEntity;
import com.codeflow.entity.ProdutoEntity;
import com.codeflow.repository.DoencaRepository;
import com.codeflow.repository.ProdutoRepository;
import com.codeflow.service.ProdutoService;
import com.codeflow.utils.ProdutoUtils;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private DoencaRepository doencaRepository;

	@Override
	public List<ProdutoEntity> getAllProduto() {
		List<ProdutoEntity> listProdutoEntity = produtoRepository.findAll();
		return listProdutoEntity;
	}

	@Override
	public ProdutoEntity postProduto(ProdutoDTO produtoDTO) {
		ProdutoEntity produtoEntity = new ProdutoEntity();
		for (Long doencaEntity : produtoDTO.getDoencas()) {
			DoencaEntity doenca = doencaRepository.findById(doencaEntity).orElse(null);
			  if (doenca != null) {
				  produtoEntity.getDoencas().add(doenca);
              }
		}
		produtoEntity.setNome(produtoDTO.getNome());
		produtoEntity.setDesconto(produtoDTO.getDesconto());
		produtoRepository.saveAndFlush(produtoEntity);
		return produtoEntity;
	}

	@Override
	public ProdutoEntity putProduto(ProdutoDTO produtoDTO) {
		getByIdProduto(produtoDTO.getId());
		ProdutoEntity produtoEntity = produtoRepository.save(ProdutoUtils.convertDTOemEntity(produtoDTO));
		return produtoEntity;
	}

	@Override
	public void deleteProduto(Long id) {
		getByIdProduto(id);
		produtoRepository.deleteById(id);
	}

	@Override
	public ProdutoEntity getByIdProduto(Long id) {
		Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
		if (produtoEntity.isPresent()) {
			return produtoEntity.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
	}

}
