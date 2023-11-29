package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FornecedorDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FornecedorMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;
import com.TCC.gerenciamentoEstoque.ports.input.FornecedorPort;
import com.TCC.gerenciamentoEstoque.ports.output.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FornecedorUseCase implements FornecedorPort {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Autowired
    FornecedorMapper fornecedorMapper;

    @Override
    public List<FornecedorDto> getAllFornecedores() {

        List<FornecedorDto> fornecedorDtos = new ArrayList<>();
        fornecedorRepository.findAll().forEach(fornecedor -> fornecedorDtos.add(fornecedorMapper.fornecedorDtoMapper(fornecedor)));
        return fornecedorDtos;
    }

    @Override
    public FornecedorDto getFornecedorByCnpj(String cnpj) {

        Fornecedor fornecedor = fornecedorRepository.findFornecedorByCnpj(cnpj);
        return fornecedorMapper.fornecedorDtoMapper(fornecedor);
    }

    @Override
    public Fornecedor createFornecedor(FornecedorDto fornecedorDto) {

        Fornecedor fornecedor = fornecedorMapper.fornecedorMapper(fornecedorDto);
        fornecedorRepository.save(fornecedor);
        return fornecedor;
    }

    @Override
    public Optional<Fornecedor> updateFornecedorById(Long id, FornecedorDto fornecedorDto) {

        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        fornecedorRepository.save(fornecedorMapper.fornecedorMapper(fornecedorDto));

        return fornecedor;
    }

    @Override
    public Optional<Fornecedor> deleteFornecedorById(Long id) {

        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        fornecedorRepository.deleteById(id);

        return fornecedor;
    }
}
