package com.codeflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeflow.entity.VendaEntity;


@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long> {

}
