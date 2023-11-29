package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.impl;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FuncionarioDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FuncionarioMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Funcionario;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioMapperImpl implements FuncionarioMapper {

    @Override
    public Funcionario funcionarioMapper(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = new Funcionario();

        funcionario.setId(funcionarioDto.getId());
        funcionario.setNome(funcionarioDto.getNome());
        funcionario.setCpf(funcionarioDto.getCpf());
        funcionario.setTelefone(funcionarioDto.getTelefone());
        funcionario.setEndereco(funcionarioDto.getEndereco());

        return funcionario;
    }

    @Override
    public FuncionarioDto funcionarioDtoMapper(Funcionario funcionario) {
        FuncionarioDto funcionarioDto = new FuncionarioDto();

        funcionarioDto.setId(funcionario.getId());
        funcionarioDto.setNome(funcionario.getNome());
        funcionarioDto.setCpf(funcionario.getCpf());
        funcionarioDto.setTelefone(funcionario.getTelefone());
        funcionarioDto.setEndereco(funcionario.getEndereco());

        return funcionarioDto;
    }
}
