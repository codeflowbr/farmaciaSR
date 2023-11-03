package com.codeflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codeflow.entity.ProdutoEntity;


@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	List<ProdutoEntity> findAllByOrderByNome();

	@Query("SELECT p.nome " +
           "FROM ProdutoEntity p " +
           "LEFT JOIN p.vendas v " +
           "GROUP BY p.id, p.nome " +
           "ORDER BY COUNT(v.id) DESC")
    List<String> encontrarNomeDoProdutoMaisVendido();

}
