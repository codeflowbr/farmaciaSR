package com.codeflow.service.impl;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeflow.entity.VendaEntity;
import com.codeflow.repository.VendaRepository;
import com.codeflow.service.MessageService;
import com.codeflow.service.VencimentoService;

@Service
public class VencimentoServiceImpl implements VencimentoService {

	@Autowired
	VendaRepository vendaRepository;

	@Autowired
	MessageService messageService;

	@Override
	public void dataVerify() {
		Locale brasil = new Locale("pt", "BR");
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(brasil);

		List<VendaEntity> listaVendas = vendaRepository
				.findAllByDataMensagemLessThanEqualAndMensagemEnviadaIsFalse(new Date());

		for (VendaEntity venda : listaVendas) {
			String nomeProduto = venda.getProdutos().get(0).getNome();
			String nomeCliente = venda.getCliente().getNome();
			String mensagem;
			if (venda.getProdutos().get(0).getDesconto() != 0
					&& venda.getProdutos().get(0).getValor() != venda.getProdutos().get(0).getDesconto()) {
				float valorDesconto = (venda.getProdutos().get(0).getDesconto());
				mensagem = "Olá " + nomeCliente
						+ ", tudo bem? Somos da Farmácia São Rafael e notamos que o seu medicamento, " + nomeProduto
						+ ", está terminando e tomamos a liberdade de separá-lo para você. Assim, poderá estar retirando em nossa loja ou se preferir, entregamos onde você estiver. O valor do produto é de "
						+ formatoMoeda.format(venda.getProdutos().get(0).getValor())
						+ ", mas com o seu desconto, ele fica por " + formatoMoeda.format(valorDesconto)
						+ ". Gostaria de antecipar sua compra para não faltar sua medicação?";
			} else {
				mensagem = "Olá " + nomeCliente
						+ ", tudo bem? Somos da Farmácia São Rafael e notamos que o seu medicamento, "
						+ venda.getProdutos().get(0).getNome()
						+ ", está terminando e tomamos a liberdade de separá-lo para você. Assim, poderá estar retirando em nossa loja ou se preferir, entregamos onde você estiver. O valor do produto, com o seu desconto, fica por "
						+ formatoMoeda.format(venda.getProdutos().get(0).getValor())
						+ ". Gostaria de antecipar sua compra para não faltar sua medicação?";
			}

			String retorno = messageService.postMessage(mensagem, venda.getCliente().getTelefone());
			if (retorno != "fail") {

				if (venda.getRecorrente() != null && venda.getRecorrente()) {
					Calendar calendar = Calendar.getInstance();
					calendar.add(Calendar.DAY_OF_MONTH, venda.getDuracao() - 3);
					venda.setDataMensagem(calendar.getTime());
				} else {
					venda.setMensagemEnviada(true);
				}
			}
		}
		vendaRepository.saveAllAndFlush(listaVendas);

	}

}
