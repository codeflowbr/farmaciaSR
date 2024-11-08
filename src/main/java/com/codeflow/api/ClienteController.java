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

import com.codeflow.dto.ClienteDTO;
import com.codeflow.service.ClienteService;
import com.codeflow.service.VencimentoService;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<?>> getAllClientes() {
		return ResponseEntity.ok(clienteService.getAllCliente());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<?>> getAllClientesilike(@PathVariable("nome") String nome) {
		return ResponseEntity.ok(clienteService.getAllClienteiLike(nome));
	}
	
	@GetMapping("/{idCliente}")
	public ResponseEntity<?> getByIdCliente(@PathVariable("idCliente") Long id) {
		return ResponseEntity.ok(clienteService.getByIdCliente(id));
	}
	
	@GetMapping("/dados/{idCliente}")
	public ResponseEntity<?> getDadosByIdCliente(@PathVariable("idCliente") Long id) {
		return ResponseEntity.ok(clienteService.getDadosByIdCliente(id));
	}

	@PostMapping
	public ResponseEntity<?> postCliente(@RequestBody ClienteDTO clienteDTO) {
		return ResponseEntity.ok(clienteService.postCliente(clienteDTO));
	}

	@PutMapping
	public ResponseEntity<?> putCliente(@RequestBody ClienteDTO clienteDTO) {
		return ResponseEntity.ok(clienteService.putCliente(clienteDTO));
	}

	@DeleteMapping("/{idCliente}")
	public ResponseEntity<?> deleteCliente(@PathVariable("idCliente") Long id) {
		clienteService.deleteCliente(id);
		return ResponseEntity.ok("O cliente com o id: " + id + " foi excluido com sucesso");
	}
	
}