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

import com.codeflow.dto.VendaDTO;
import com.codeflow.service.VendaService;
import com.codeflow.service.VencimentoService;

@RestController
@RequestMapping("api/v1/venda")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@GetMapping
	public ResponseEntity<List<VendaDTO>> getAllVendas() {
		return ResponseEntity.ok(vendaService.getAllVenda());
	}

	@GetMapping("/{idVenda}")
	public ResponseEntity<?> getByIdVenda(@PathVariable("idVenda") Long id) {
		return ResponseEntity.ok(vendaService.getByIdVenda(id));
	}

	@PostMapping
	public ResponseEntity<?> postVenda(@RequestBody VendaDTO vendaDTO) {
		return ResponseEntity.ok(vendaService.postVenda(vendaDTO));
	}

	@PutMapping
	public ResponseEntity<?> putVenda(@RequestBody VendaDTO vendaDTO) {
		return ResponseEntity.ok(vendaService.putVenda(vendaDTO));
	}

	@DeleteMapping("/{idVenda}")
	public ResponseEntity<?> deleteVenda(@PathVariable("idVenda") Long id) {
		vendaService.deleteVenda(id);
		return ResponseEntity.ok("O venda com o id: " + id + " foi excluido com sucesso");
	}
	
}