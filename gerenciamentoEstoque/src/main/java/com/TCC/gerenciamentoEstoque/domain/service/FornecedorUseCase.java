package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FornecedorDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FornecedorMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;
import com.TCC.gerenciamentoEstoque.ports.input.FornecedorPort;
import com.TCC.gerenciamentoEstoque.ports.output.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorUseCase implements FornecedorPort {

    private static String REGEX = "[^0-9]";

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Autowired
    FornecedorMapper fornecedorMapper;

    @Override
    public List<FornecedorDto> getAllFornecedores() {

        List<FornecedorDto> fornecedorDtos = new ArrayList<>();
        fornecedorRepository.findAll().forEach(fornecedor -> fornecedorDtos.add(fornecedorMapper.fornecedorDtoMapper(fornecedor)));
        if(fornecedorDtos.size()<1){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }

        return fornecedorDtos;
    }

    @Override
    public FornecedorDto getFornecedorByCnpj(String cnpj) throws CustomException{

        Fornecedor fornecedor = fornecedorRepository.findFornecedorByCnpj(cnpj);
        if(fornecedor.getCnpj().isEmpty()||fornecedor.getCnpj().isBlank()){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));

        }

        return fornecedorMapper.fornecedorDtoMapper(fornecedor);
    }

    @Override
    public Fornecedor createFornecedor(FornecedorDto fornecedorDto) throws CustomException {

        fornecedorDto.setCnpj(fornecedorDto.getCnpj().replaceAll(REGEX,""));

        Fornecedor fornecedor = fornecedorMapper.fornecedorMapper(fornecedorDto);
        Optional<Fornecedor> fornecedorOptional = Optional.ofNullable(fornecedorRepository
                .findFornecedorByCnpj(fornecedorDto.getCnpj()));

        if(fornecedorOptional.isPresent()){
            throw new CustomException("CNPJ já cadastrado",  ResponseEntity.status(400).body("Já Existe"));
        }

        fornecedorRepository.save(fornecedor);
        return fornecedor;
    }

    @Override
    public Fornecedor updateFornecedorById(Long id, FornecedorDto fornecedorDto) throws CustomException {
        try {

            Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow();

            fornecedor.setCnpj(fornecedorDto.getCnpj());
            fornecedor.setRazaoSocial(fornecedorDto.getRazaoSocial());
            fornecedor.setEndereço(fornecedorDto.getEndereço());
            fornecedor.setTelefone(fornecedorDto.getTelefone());

            fornecedorRepository.save(fornecedor);

            return fornecedor;
        }catch (CustomException e){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));

        }
    }

    @Override
    public Fornecedor deleteFornecedorById(Long id) throws CustomException {
        try {
            Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow();
            fornecedorRepository.deleteById(id);

            return fornecedor;
        }catch (CustomException e) {
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
    }
}
