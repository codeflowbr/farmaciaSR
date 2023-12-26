package com.codeflow.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeflow.dto.ClienteMensalDTO;
import com.codeflow.dto.DashboardDTO;
import com.codeflow.dto.MensagemMensalDTO;
import com.codeflow.repository.ClienteRepository;
import com.codeflow.repository.DoencaRepository;
import com.codeflow.repository.ProdutoRepository;
import com.codeflow.repository.VendaRepository;
import com.codeflow.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {
	
	@Autowired
	VendaRepository vendaRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;

	
	@Override
	public DashboardDTO getData() {
		
		  String[] meses = {
		            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
		            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
		        };
		
		DashboardDTO dashboard = new DashboardDTO();
		dashboard.setTotalMsg(vendaRepository.countByMensagemEnviadaTrue());
		dashboard.setTotalCli(clienteRepository.count());
		dashboard.setTotalProd(produtoRepository.count());
	
		LocalDate oneYearAgo = LocalDate.now().minusYears(1);
		Date oneYearAgoAsDate = Date.from(oneYearAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
		 List<Object[]> resultProduct = vendaRepository.findQuantityByMonthAndYearMensagem(oneYearAgoAsDate);
	     List<MensagemMensalDTO> trocasMensais = new ArrayList<>();
		 for (Object[] row : resultProduct) {
			// Acessar os valores retornados pela consulta
			int mes = (int) row[0];
			int ano = (int) row[1];
			Long quantidade = (Long) row[2];
			MensagemMensalDTO trocaDTO = new MensagemMensalDTO();
			trocaDTO.setX(meses[mes-1]);
			trocaDTO.setY(BigDecimal.valueOf(quantidade));
			trocasMensais.add(trocaDTO);
		}
		dashboard.setMensagemMensal(trocasMensais);

		List<Object[]> resultCliente = clienteRepository.findQuantityByMonthAndYearCadastro(oneYearAgoAsDate);
		 
        List<ClienteMensalDTO> clientesMensais = new ArrayList<>();
		for (Object[] row : resultCliente) {
			// Acessar os valores retornados pela consulta
			int mes = (int) row[0];
			int ano = (int) row[1];
			Long quantidade = (Long) row[2];
			ClienteMensalDTO trocaDTO = new ClienteMensalDTO();
			trocaDTO.setX(meses[mes-1]);
			trocaDTO.setY(BigDecimal.valueOf(quantidade));
			clientesMensais.add(trocaDTO);
		}
		
		dashboard.setClienteMensal(clientesMensais);
		
		
		
		Long totalRevenda = vendaRepository.countByRevendaTrue();
		
		dashboard.setTotalRevenda(totalRevenda);
		
		Double valorTotal = vendaRepository.calcularValorTotalDeTodasAsVendas();
		
		dashboard.setTotalValor(valorTotal);
		
		dashboard.setProdutoMaisVendido(vendaRepository.encontrarNomeProdutoMaisVendido().get());
		
		return dashboard;
	}


}
