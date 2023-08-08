package com.codeflow.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeflow.dto.LoginDTO;
import com.codeflow.service.CustomerService;
import com.codeflow.service.UsuarioService;

@RestController
@RequestMapping("api/v1/login")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping()
	public ResponseEntity<?> getCustomer(@RequestBody LoginDTO loginDTO) {
		return ResponseEntity.ok(usuarioService.getLogin(loginDTO));
	}

}
