package com.caiovlf.money.api.repository.lancamento;

import java.util.List;

import com.caiovlf.money.api.model.Lancamento;
import com.caiovlf.money.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
		

}
