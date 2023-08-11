package com.codeflow.service;

import java.util.List;

import com.codeflow.dto.ProdutoDTO;
import com.codeflow.entity.ProdutoEntity;

/**
 * Serviço de produtos.
 */
public interface ProdutoService {

	/**
	 * Buscar todos os produtos.
	 * 
	 * @return lista de produto dto.
	 */
	public List<ProdutoEntity> getAllProduto();
	
	

	/**
	 * Adicionar novo produto.
	 * 
	 * @param produtoDTO dto de produto
	 * @return lista de produto dto.
	 */
	public ProdutoEntity postProduto(ProdutoDTO produtoDTO);
	

	/**
	 * EditarProduto
	 * 
	 * @return lista de produto dto.
	 */
	public ProdutoEntity putProduto(ProdutoDTO produtoDTO);

	/**
	 * EditarProduto
	 * 
	 * @param id id do produto a ser excluido.
	 */
	public void deleteProduto(Long id);

	/**
	 * Buscar Produto pelo id.
	 * 
	 * @param id id do produto
	 * @return produto encontrado
	 */
	public ProdutoEntity getByIdProduto(Long id);

}
