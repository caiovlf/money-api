package com.caiovlf.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiovlf.money.api.model.Lancamento;
import com.caiovlf.money.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> , LancamentoRepositoryQuery{

}
