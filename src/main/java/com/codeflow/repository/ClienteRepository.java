package com.codeflow.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codeflow.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	List<ClienteEntity> findByNomeIgnoreCaseContaining(String nome);

	@Query("SELECT MONTH(c.dataCadastro) AS mes, YEAR(c.dataCadastro) AS ano, COUNT(c.id) AS quantidade "
			+ "FROM cliente c " + "WHERE c.dataCadastro >= :oneYearAgo "
			+ "GROUP BY MONTH(c.dataCadastro), YEAR(c.dataCadastro)")
	List<Object[]> findQuantityByMonthAndYearCadastro(@Param("oneYearAgo") Date oneYearAgo);

	@Query("SELECT DISTINCT p.doenca FROM cliente c JOIN c.doencas p WHERE c.id = :userId")
	List<String> finddoencasNamesByUserId(@Param("userId") Long userId);
}
