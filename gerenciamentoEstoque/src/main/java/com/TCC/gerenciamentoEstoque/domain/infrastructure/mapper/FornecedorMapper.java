package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FornecedorDto;
import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;

public interface FornecedorMapper {

    Fornecedor fornecedorMapper (FornecedorDto fornecedorDto);

    FornecedorDto fornecedorDtoMapper (Fornecedor fornecedor);
}
