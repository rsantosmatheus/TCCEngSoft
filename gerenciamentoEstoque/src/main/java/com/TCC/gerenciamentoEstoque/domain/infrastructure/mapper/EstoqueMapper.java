package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.EstoqueDto;
import com.TCC.gerenciamentoEstoque.domain.model.Estoque;

public interface EstoqueMapper {

    Estoque estoqueMapper (EstoqueDto estoqueDto);

    EstoqueDto estoqueDtoMapper (Estoque estoque);
}
