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

import com.codeflow.dto.DoencaDTO;
import com.codeflow.service.DoencaService;
import com.codeflow.service.VencimentoService;

@RestController
@RequestMapping("api/v1/doenca")
public class DoencaController {

	@Autowired
	private DoencaService doencaService;

	@GetMapping
	public ResponseEntity<List<DoencaDTO>> getAllDoencas() {
		return ResponseEntity.ok(doencaService.getAllDoenca());
	}

	@GetMapping("/{idDoenca}")
	public ResponseEntity<?> getByIdDoenca(@PathVariable("idDoenca") Long id) {
		return ResponseEntity.ok(doencaService.getByIdDoenca(id));
	}

	@PostMapping
	public ResponseEntity<?> postDoenca(@RequestBody DoencaDTO doencaDTO) {
		return ResponseEntity.ok(doencaService.postDoenca(doencaDTO));
	}

	@PutMapping
	public ResponseEntity<?> putDoenca(@RequestBody DoencaDTO doencaDTO) {
		return ResponseEntity.ok(doencaService.putDoenca(doencaDTO));
	}

	@DeleteMapping("/{idDoenca}")
	public ResponseEntity<?> deleteDoenca(@PathVariable("idDoenca") Long id) {
		doencaService.deleteDoenca(id);
		return ResponseEntity.ok("O doenca com o id: " + id + " foi excluido com sucesso");
	}
	
}