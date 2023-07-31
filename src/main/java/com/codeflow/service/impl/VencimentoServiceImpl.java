package com.codeflow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeflow.repository.ProdutoRepository;
import com.codeflow.service.VencimentoService;

@Service
public class VencimentoServiceImpl implements VencimentoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Override
	public void dataVerify() {
		
	}

}
