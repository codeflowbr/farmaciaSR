package com.codeflow.service.impl;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeflow.dto.VendaDTO;
import com.codeflow.entity.VendaEntity;
import com.codeflow.repository.ProdutoRepository;
import com.codeflow.repository.VendaRepository;
import com.codeflow.service.MessageService;
import com.codeflow.service.VencimentoService;
import com.codeflow.utils.VendaUtils;

@Service
public class VencimentoServiceImpl implements VencimentoService {
	
	@Autowired
	VendaRepository vendaRepository;
	
	@Autowired
	MessageService messageService;
	
	@Override
	public void dataVerify() {
		List<VendaEntity> listaVendas = vendaRepository.findAllByMensagemEnviada(false);
		
		for (VendaEntity venda : listaVendas) {
			String nomeProduto = venda.getProdutos().get(0).getNome();
			String nomeCliente = venda.getCliente().getNome();
			
			String mensagem = "Olá " + nomeCliente + " notamos que seu produto "+nomeProduto+" está acabando , aproveite a oferta de "+venda.getProdutos().get(0).getDesconto()+"% e antecipe a sua compra.";
			
			messageService.postMessage(mensagem, venda.getCliente().getTelefone());
			
			if(venda.getRecorrente()) {
				 Calendar calendar = Calendar.getInstance();
				 calendar.add(Calendar.DAY_OF_MONTH, venda.getDuracao() - 5);
			}else{
				venda.setMensagemEnviada(true);
			}
		}
		vendaRepository.saveAllAndFlush(listaVendas);
		
	}

}
