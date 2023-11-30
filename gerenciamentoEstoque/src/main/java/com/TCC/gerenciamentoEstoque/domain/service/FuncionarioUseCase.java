package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FuncionarioDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FuncionarioMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Funcionario;
import com.TCC.gerenciamentoEstoque.ports.input.FuncionarioPort;
import com.TCC.gerenciamentoEstoque.ports.output.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioUseCase implements FuncionarioPort{

    private static String REGEX = "[^0-9]";

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
    public FuncionarioDto getFuncionarioByCpf(String cpf) throws CustomException{
        Funcionario funcionario = funcionarioRepository.findFuncionarioByCpf(cpf);
        if (funcionario.getCpf().isBlank() || funcionario.getCpf().isEmpty()){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }

        return funcionarioMapper.funcionarioDtoMapper(funcionario);
    }

    @Override
    public Funcionario createFuncionario(FuncionarioDto funcionarioDto) throws CustomException{

        funcionarioDto.setCpf(funcionarioDto.getCpf().replaceAll(REGEX,""));

        Funcionario funcionario = funcionarioMapper.funcionarioMapper(funcionarioDto);
        Optional<Funcionario> funcionarioOptional = Optional.ofNullable(funcionarioRepository.findFuncionarioByCpf(funcionarioDto.getCpf()));

        if (funcionarioOptional.isPresent()) {
            throw new CustomException("Já cadastrado",  ResponseEntity.status(400).body("Já Existe"));
        }

        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    @Override
    public Funcionario updateFuncionario(Long id, FuncionarioDto funcionarioDto) throws CustomException{
        try {
            Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();

            funcionario.setCpf(funcionarioDto.getCpf());
            funcionario.setNome(funcionarioDto.getNome());
            funcionario.setTelefone(funcionarioDto.getTelefone());
            funcionario.setEndereco(funcionarioDto.getEndereco());
            funcionarioRepository.save(funcionario);

            return funcionario;
        }catch (CustomException e) {
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }

    }

    @Override
    public Funcionario deleteFuncionarioById(Long id) throws CustomException {
        try {
            Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();
            funcionarioRepository.deleteById(id);
            return funcionario;
        }  catch (CustomException e){
        throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }

    }
}
