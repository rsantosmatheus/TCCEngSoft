package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.impl;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.EstoqueDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.EstoqueMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ProdutoMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Estoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueMapperImpl implements EstoqueMapper {

    @Autowired
    ProdutoMapper produtoMapper;

    @Override
    public Estoque estoqueMapper(EstoqueDto estoqueDto) {
        Estoque estoque = new Estoque();

        estoque.setId(estoqueDto.getId());
        estoque.setProduto(produtoMapper.produtoMapper(estoqueDto.getProduto()));
        estoque.setQuantidade(estoqueDto.getQuantidade());

        return estoque;
    }

    @Override
    public EstoqueDto estoqueDtoMapper(Estoque estoque) {
        EstoqueDto estoqueDto = new EstoqueDto();

        estoqueDto.setId(estoque.getId());
        estoqueDto.setProduto(produtoMapper.produtoDtoMapper(estoque.getProduto()));
        estoqueDto.setQuantidade(estoque.getQuantidade());

        return estoqueDto;
    }
}
