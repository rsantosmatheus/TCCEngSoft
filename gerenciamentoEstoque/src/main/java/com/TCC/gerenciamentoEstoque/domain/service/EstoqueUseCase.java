package com.TCC.gerenciamentoEstoque.domain.service;


import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.EstoqueDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.EstoqueMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Estoque;
import com.TCC.gerenciamentoEstoque.ports.input.EstoquePort;
import com.TCC.gerenciamentoEstoque.ports.output.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueUseCase implements EstoquePort {

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    EstoqueMapper estoqueMapper;

    @Override
    public List<EstoqueDto> getAllEstoque() {

        List<EstoqueDto> estoqueDtos = new ArrayList<>();
        estoqueRepository.findAll().forEach(estoque -> estoqueDtos.add(estoqueMapper.estoqueDtoMapper(estoque)));
        if(estoqueDtos.size()<1){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }

        return estoqueDtos;
    }

    @Override
    public EstoqueDto getEstoqueById(Long id)  throws CustomException {
        Estoque estoque = estoqueRepository.findById(id).orElseThrow();
        EstoqueDto estoqueDto = estoqueMapper.estoqueDtoMapper(estoque);
        return estoqueDto;
    }

    @Override
    public EstoqueDto getProdutoByCodInternoProduto(int codInternoProduto) {
        Estoque estoque = estoqueRepository.findEstoqueByCodInterno(codInternoProduto);
        if(estoque == null){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
        return estoqueMapper.estoqueDtoMapper(estoque);
    }

    @Override
    public String getValorEstoque() {

        return estoqueRepository.somarValorCompraProdutosEmEstoque().toString();
    }

    @Override
    public String getValorPotecialEstoque() {
        return estoqueRepository.somarValorVendaProdutosEmEstoque().toString();
    }
}
