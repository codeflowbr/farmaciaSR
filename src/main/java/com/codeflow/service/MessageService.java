package com.codeflow.service;


import com.codeflow.dto.DoencaDTO;

/**
 * Serviço de mensagens.
 */
public interface MessageService {

	/**
	 * Envia mensagem
	 * @param message mensage
	 * @param number numero
	 * @return 
	 */
	public String postMessage(String message, String number);

}
