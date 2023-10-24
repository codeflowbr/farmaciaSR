package com.codeflow.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codeflow.dto.VendaDTO;
import com.codeflow.entity.VendaEntity;


@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long> {

	List<VendaEntity> findAllByMensagemEnviada(boolean b);
	
	List<VendaEntity> findAllByRevenda(boolean b);
	
	List<VendaEntity> findAllByDataMensagemLessThanEqualAndMensagemEnviadaIsFalse(Date currentDate);

	
	long countByMensagemEnviadaTrue();

	
	@Query("SELECT MONTH(v.dataMensagem) AS mes, YEAR(v.dataMensagem) AS ano, COUNT(v.id) AS quantidade " +
		       "FROM venda v " +
		       "WHERE v.mensagemEnviada = true " +
		       "AND v.dataMensagem >= :oneYearAgo " +
		       "GROUP BY MONTH(v.dataMensagem), YEAR(v.dataMensagem)")
	List<Object[]> findQuantityByMonthAndYearMensagem(@Param("oneYearAgo") Date oneYearAgo);

	  @Query("SELECT DISTINCT p.nome FROM venda v JOIN v.produtos p WHERE v.cliente.id = :userId")
	  List<String> findProdutoNamesByUserId(@Param("userId") Long userId);


}
