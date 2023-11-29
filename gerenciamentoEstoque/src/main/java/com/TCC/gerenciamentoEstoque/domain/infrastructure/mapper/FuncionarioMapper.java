package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FuncionarioDto;
import com.TCC.gerenciamentoEstoque.domain.model.Funcionario;

public interface FuncionarioMapper {

    Funcionario funcionarioMapper (FuncionarioDto funcionarioDto);

    FuncionarioDto funcionarioDtoMapper (Funcionario funcionario);
}
