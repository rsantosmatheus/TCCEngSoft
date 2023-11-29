package com.TCC.gerenciamentoEstoque.ports.input;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FornecedorDto;
import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;

import java.util.List;
import java.util.Optional;

public interface FornecedorPort {


    List<FornecedorDto> getAllFornecedores();

    FornecedorDto getFornecedorByCnpj(String cnpj);

    Fornecedor createFornecedor(FornecedorDto fornecedorDto);

    Optional<Fornecedor> updateFornecedorById(Long id, FornecedorDto fornecedorDto);

    Optional<Fornecedor> deleteFornecedorById(Long id);
}
