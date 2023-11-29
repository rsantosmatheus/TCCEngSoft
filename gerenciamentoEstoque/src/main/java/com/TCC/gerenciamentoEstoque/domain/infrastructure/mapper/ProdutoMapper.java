package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ProdutoDto;
import com.TCC.gerenciamentoEstoque.domain.model.Produto;

public interface ProdutoMapper {

    Produto produtoMapper (ProdutoDto produtoDto);

    ProdutoDto produtoDtoMapper (Produto produto);
}
