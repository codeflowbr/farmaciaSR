package com.codeflow.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeflow.dto.VendaDTO;
import com.codeflow.entity.VendaEntity;


@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long> {

	List<VendaEntity> findAllByMensagemEnviada(boolean b);
	
	List<VendaEntity> findByDataMensagemLessThanEqualAndMensagemEnviadaIsFalse(Date currentDate);


}
