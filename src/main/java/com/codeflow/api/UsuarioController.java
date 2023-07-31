package com.codeflow.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeflow.dto.UsuarioDTO;
import com.codeflow.service.UsuarioService;
import com.codeflow.service.VencimentoService;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
		return ResponseEntity.ok(usuarioService.getAllUsuario());
	}

	@GetMapping("/{idUsuario}")
	public ResponseEntity<?> getByIdUsuario(@PathVariable("idUsuario") Long id) {
		return ResponseEntity.ok(usuarioService.getByIdUsuario(id));
	}

	@PostMapping
	public ResponseEntity<?> postUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		return ResponseEntity.ok(usuarioService.postUsuario(usuarioDTO));
	}

	@PutMapping
	public ResponseEntity<?> putUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		return ResponseEntity.ok(usuarioService.putUsuario(usuarioDTO));
	}

	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<?> deleteUsuario(@PathVariable("idUsuario") Long id) {
		usuarioService.deleteUsuario(id);
		return ResponseEntity.ok("O usuario com o id: " + id + " foi excluido com sucesso");
	}
	
}