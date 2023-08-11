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
		List<DoencaEntity> doencas = new ArrayList<>();
		for (Long doencaEntity : produtoDTO.getDoencas()) {
			doencas.add(doencaRepository.getById(doencaEntity));
		}
		produtoDTO.setDoencas(null);
		ProdutoEntity produtoEntity = new ProdutoEntity();
		produtoEntity.setNome(produtoDTO.getNome());
		produtoEntity.setDesconto(produtoDTO.getDesconto());
		produtoEntity.setDoencas(doencas);
		ProdutoEntity produtoEntityreturn = produtoRepository.saveAndFlush(produtoEntity);
		return produtoEntityreturn;
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
