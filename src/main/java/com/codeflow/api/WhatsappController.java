package com.codeflow.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeflow.dto.VendaDTO;
import com.codeflow.service.MessageService;
import com.codeflow.service.VendaService;

@RestController
@RequestMapping("api/v1/whatsapp")
public class WhatsappController {

	@Autowired
	private MessageService whatsappService;

	@GetMapping
	public ResponseEntity<String> getAllVendas() {
		whatsappService.postMessage("Teste api no java", "554599367427");
		return ResponseEntity.ok("ok");
	}
}
