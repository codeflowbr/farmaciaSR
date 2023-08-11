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

import com.codeflow.dto.ProdutoDTO;
import com.codeflow.entity.ProdutoEntity;
import com.codeflow.service.ProdutoService;
import com.codeflow.service.VencimentoService;

@RestController
@RequestMapping("api/v1/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<ProdutoEntity>> getAllProdutos() {
		return ResponseEntity.ok(produtoService.getAllProduto());
	}

	@GetMapping("/{idProduto}")
	public ResponseEntity<?> getByIdProduto(@PathVariable("idProduto") Long id) {
		return ResponseEntity.ok(produtoService.getByIdProduto(id));
	}

	@PostMapping
	public ResponseEntity<?> postProduto(@RequestBody ProdutoDTO produtoDTO) {
		return ResponseEntity.ok(produtoService.postProduto(produtoDTO));
	}

	@PutMapping
	public ResponseEntity<?> putProduto(@RequestBody ProdutoDTO produtoDTO) {
		return ResponseEntity.ok(produtoService.putProduto(produtoDTO));
	}

	@DeleteMapping("/{idProduto}")
	public ResponseEntity<?> deleteProduto(@PathVariable("idProduto") Long id) {
		produtoService.deleteProduto(id);
		return ResponseEntity.ok("O produto com o id: " + id + " foi excluido com sucesso");
	}
	
}