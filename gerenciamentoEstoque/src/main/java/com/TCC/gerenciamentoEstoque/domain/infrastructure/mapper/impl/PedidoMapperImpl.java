package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.impl;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.PedidoDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FornecedorMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FuncionarioMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.PedidoMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ProdutoMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoMapperImpl implements PedidoMapper {

    @Autowired
    ProdutoMapper produtoMapper;

    @Autowired
    FuncionarioMapper funcionarioMapper;

    @Autowired
    FornecedorMapper fornecedorMapper;


    @Override
    public Pedido pedidoMapper(PedidoDto pedidoDto) {
        Pedido pedido = new Pedido();

        pedido.setId(pedidoDto.getId());
        pedido.setProduto(produtoMapper.produtoMapper(pedidoDto.getProduto()));
        pedido.setQuantidade(pedidoDto.getQuantidade());
        pedido.setFuncionario(funcionarioMapper.funcionarioMapper(pedidoDto.getFuncionario()));
        pedido.setData(pedidoDto.getData());
        pedido.setFornecedor(fornecedorMapper.fornecedorMapper(pedidoDto.getFornecedor()));

        return pedido;
    }

    @Override
    public PedidoDto pedidoDtoMapper(Pedido pedido) {
        PedidoDto pedidoDto = new PedidoDto();

        pedidoDto.setId(pedido.getId());
        pedidoDto.setProduto(produtoMapper.produtoDtoMapper(pedido.getProduto()));
        pedidoDto.setQuantidade(pedidoDto.getQuantidade());
        pedidoDto.setFuncionario(funcionarioMapper.funcionarioDtoMapper(pedido.getFuncionario()));
        pedidoDto.setData(pedidoDto.getData());
        pedidoDto.setFornecedor(fornecedorMapper.fornecedorDtoMapper(pedido.getFornecedor()));

        return pedidoDto;
    }
}
