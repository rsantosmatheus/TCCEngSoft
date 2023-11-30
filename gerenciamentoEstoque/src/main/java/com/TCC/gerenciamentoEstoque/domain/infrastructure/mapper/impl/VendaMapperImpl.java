package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.impl;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ProdutoDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.VendaDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ClienteMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FuncionarioMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ProdutoMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.VendaMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Produto;
import com.TCC.gerenciamentoEstoque.domain.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaMapperImpl implements VendaMapper {

    @Autowired
    ProdutoMapper produtoMapper;

    @Autowired
    ClienteMapper clienteMapper;

    @Autowired
    FuncionarioMapper funcionarioMapper;

    @Override
    public Venda vendaMapper(VendaDto vendaDto) {
        Venda venda = new Venda();

        venda.setId(vendaDto.getId());
        venda.setProduto(produtoMapper.produtoMapper(vendaDto.getProduto()));
        venda.setCliente(clienteMapper.clienteMapper(vendaDto.getCliente()));
        venda.setFuncionario(funcionarioMapper.funcionarioMapper(vendaDto.getFuncionario()));
        venda.setData(vendaDto.getData());

        return venda;
    }

    @Override
    public VendaDto vendaDtoMapper(Venda venda) {
        VendaDto vendaDto = new VendaDto();

        vendaDto.setId(venda.getId());
        vendaDto.setProduto(produtoMapper.produtoDtoMapper(venda.getProduto()));
        vendaDto.setCliente(clienteMapper.clienteDtoMapper(venda.getCliente()));
        vendaDto.setFuncionario(funcionarioMapper.funcionarioDtoMapper(venda.getFuncionario()));
        vendaDto.setData(venda.getData());

        return vendaDto;
    }
}
