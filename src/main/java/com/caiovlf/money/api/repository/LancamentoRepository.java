package com.caiovlf.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiovlf.money.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
