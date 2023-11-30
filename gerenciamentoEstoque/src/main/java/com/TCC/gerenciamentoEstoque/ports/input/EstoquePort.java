package com.TCC.gerenciamentoEstoque.ports.input;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.EstoqueDto;

import java.util.List;

public interface EstoquePort {
    List<EstoqueDto> getAllEstoque();

    EstoqueDto getEstoqueById(Long id);

    EstoqueDto getProdutoByCodInternoProduto(int codInternoProduto);

    String getValorEstoque();

    String getValorPotecialEstoque();
}
