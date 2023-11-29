package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.impl;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ProdutoDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FornecedorMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ProdutoMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoMapperImpl implements ProdutoMapper {

    @Autowired
    FornecedorMapper fornecedorMapper;

    @Override
    public Produto produtoMapper(ProdutoDto produtoDto) {
        Produto produto = new Produto();

        produto.setId(produtoDto.getId());
        produto.setNome(produtoDto.getNome());
        produto.setValorVenda(produtoDto.getValorVenda());
        produto.setValorCompra(produtoDto.getValorCompra());
        produto.setQuantidadeMinima(produtoDto.getQuantidadeMinima());
        produto.setFornecedor(fornecedorMapper.fornecedorMapper(produtoDto.getFornecedor()));

        return produto;
    }

    @Override
    public ProdutoDto produtoDtoMapper(Produto produto) {
        ProdutoDto produtoDto = new ProdutoDto();

        produtoDto.setId(produto.getId());
        produtoDto.setNome(produto.getNome());
        produtoDto.setValorVenda(produto.getValorVenda());
        produtoDto.setValorCompra(produto.getValorCompra());
        produtoDto.setQuantidadeMinima(produto.getQuantidadeMinima());
        produtoDto.setFornecedor(fornecedorMapper.fornecedorDtoMapper(produto.getFornecedor()));

        return produtoDto;
    }
}
