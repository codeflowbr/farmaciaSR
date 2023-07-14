package com.codeflow.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeflow.service.VencimentoService;

@RestController
@RequestMapping("api/v1/vencimento")
public class VencimentoController {

	@Autowired
	VencimentoService vencimentoService;
	
    @GetMapping()
    public ResponseEntity<String> verifyPoints() {
    	vencimentoService.dataVerify();
        return ResponseEntity.ok("Verificação de vencimentos ok.");
    }
}