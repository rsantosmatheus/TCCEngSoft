package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.impl;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FornecedorDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FornecedorMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;
import org.springframework.stereotype.Service;

@Service
public class FornecedorMapperImpl implements FornecedorMapper {
    @Override
    public Fornecedor fornecedorMapper(FornecedorDto fornecedorDto) {
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setId(fornecedorDto.getId());
        fornecedor.setRazaoSocial(fornecedorDto.getRazaoSocial());
        fornecedor.setCnpj(fornecedorDto.getCnpj());
        fornecedor.setEndereço(fornecedorDto.getEndereço());
        fornecedor.setTelefone(fornecedorDto.getTelefone());

        return fornecedor;
    }

    @Override
    public FornecedorDto fornecedorDtoMapper(Fornecedor fornecedor) {
        FornecedorDto fornecedorDto = new FornecedorDto();

        fornecedorDto.setId(fornecedor.getId());
        fornecedorDto.setRazaoSocial(fornecedor.getRazaoSocial());
        fornecedorDto.setCnpj(fornecedor.getCnpj());
        fornecedorDto.setEndereço(fornecedor.getEndereço());
        fornecedorDto.setTelefone(fornecedor.getTelefone());

        return fornecedorDto;
    }
}
