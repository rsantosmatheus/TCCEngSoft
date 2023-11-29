package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FuncionarioDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FuncionarioMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Funcionario;
import com.TCC.gerenciamentoEstoque.ports.input.FuncionarioPort;
import com.TCC.gerenciamentoEstoque.ports.output.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioUseCase implements FuncionarioPort{

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    FuncionarioMapper funcionarioMapper;


    @Override
    public List<FuncionarioDto> getAllFuncionarios() {

        List<FuncionarioDto> funcionarioDtos = new ArrayList<>();
        funcionarioRepository.findAll().forEach(funcionario -> funcionarioDtos.add(funcionarioMapper.funcionarioDtoMapper(funcionario)));

        return funcionarioDtos;
    }

    @Override
    public FuncionarioDto getFuncionarioByCpf(String cpf) {
        return funcionarioMapper.funcionarioDtoMapper(funcionarioRepository.findFuncionarioByCpf(cpf));
    }

    @Override
    public Funcionario createFuncionario(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = funcionarioMapper.funcionarioMapper(funcionarioDto);
        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    @Override
    public Optional<Funcionario> updateFuncionario(Long id, FuncionarioDto funcionarioDto) {

        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

        return funcionario;
    }

    @Override
    public Optional<Funcionario> deleteFuncionarioById(Long id) {

        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        funcionarioRepository.deleteById(id);

        return funcionario;
    }
}
