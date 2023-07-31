package com.codeflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeflow.entity.DoencaEntity;


@Repository
public interface DoencaRepository extends JpaRepository<DoencaEntity, Long> {

}
