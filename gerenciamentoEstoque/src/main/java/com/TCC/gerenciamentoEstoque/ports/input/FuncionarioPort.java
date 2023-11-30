package com.TCC.gerenciamentoEstoque.ports.input;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FuncionarioDto;
import com.TCC.gerenciamentoEstoque.domain.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioPort {

    List<FuncionarioDto> getAllFuncionarios();

    FuncionarioDto getFuncionarioByCpf(String cpf);

    Funcionario createFuncionario(FuncionarioDto funcionarioDto);

    Funcionario updateFuncionario(Long id, FuncionarioDto funcionarioDto);

    Funcionario deleteFuncionarioById(Long id);
}
