package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.PedidoDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.PedidoMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ProdutoMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Estoque;
import com.TCC.gerenciamentoEstoque.domain.model.Pedido;
import com.TCC.gerenciamentoEstoque.ports.input.PedidoPort;
import com.TCC.gerenciamentoEstoque.ports.output.EstoqueRepository;
import com.TCC.gerenciamentoEstoque.ports.output.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoUseCase implements PedidoPort {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidoMapper pedidoMapper;

    @Autowired
    ProdutoMapper produtoMapper;

    @Autowired
    EstoqueRepository estoqueRepository;

    @Override
    public List<PedidoDto> getAllPedidos() throws CustomException{

        List<PedidoDto> pedidoDtos = new ArrayList<>();
        pedidoRepository.findAll().forEach(pedido -> pedidoDtos.add(pedidoMapper.pedidoDtoMapper(pedido)));
        if(pedidoDtos.size()<1){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
        return pedidoDtos;
    }

    @Override
    public List<PedidoDto> getAllPedidosByIdProduto(Long idProduto) throws CustomException{
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        pedidoRepository.findPedidoByProdudoId(idProduto).forEach(pedido -> pedidoDtos.add(pedidoMapper.pedidoDtoMapper(pedido)));
        if(pedidoDtos.size()<1){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
        return pedidoDtos;
    }

    @Override
    public List<PedidoDto> getAllPedidosByIdFornecedor(Long idFornecedor) throws CustomException{
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        pedidoRepository.findPedidoByFornecedorId(idFornecedor).forEach(pedido -> pedidoDtos.add(pedidoMapper.pedidoDtoMapper(pedido)));
        if(pedidoDtos.size()<1){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }

        return pedidoDtos;
    }

    @Override
    public List<PedidoDto> getAllPedidosByIdFuncionario(Long idFuncionario) throws CustomException{
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        pedidoRepository.findPedidoByFuncionarioId(idFuncionario).forEach(pedido -> pedidoDtos.add(pedidoMapper.pedidoDtoMapper(pedido)));
        if(pedidoDtos.size()<1){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
        return pedidoDtos;
    }

    @Override
    public PedidoDto getPedidoById(Long id) throws CustomException{
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();

        return pedidoMapper.pedidoDtoMapper(pedido);
    }

    @Override
    public Pedido createPedido(PedidoDto pedidoDto) throws CustomException{

        Pedido pedido = pedidoMapper.pedidoMapper(pedidoDto);
        Estoque estoque = estoqueRepository.findEstoqueByCodInterno(pedido.getProduto().getCodInterno());

        if (estoque.getProduto() == null){
            estoque.setQuantidade(pedido.getQuantidade());
            estoque.setProduto(pedido.getProduto());
        }else{
            estoque.setQuantidade(estoque.getQuantidade() + pedido.getQuantidade());
        }

        pedidoRepository.save(pedido);
        estoqueRepository.save(estoque);

        return pedido;
    }

    @Override
    public Pedido updatePedido(Long id, PedidoDto pedidoDto) throws CustomException {
        try {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();

        if(pedidoDto.getQuantidade() != pedido.getQuantidade()){
            Estoque estoque = estoqueRepository.findEstoqueByCodInterno(pedidoDto.getProduto().getCodInterno());
            estoque.setQuantidade(estoque.getQuantidade() + (pedidoDto.getQuantidade() - pedido.getQuantidade()));
            estoqueRepository.save(estoque);
        }
        pedido.setProduto(produtoMapper.produtoMapper(pedidoDto.getProduto()));
        pedido.setQuantidade(pedidoDto.getQuantidade());
        pedido.setFuncionario(pedido.getFuncionario());
        pedido.setFornecedor(pedido.getFornecedor());
        pedido.setData(pedido.getData());

        pedidoRepository.save(pedido);

        return pedido;
        }catch (CustomException e){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
    }

    @Override
    public Pedido deletePedidoById(Long id) throws CustomException{
        try {
            Pedido pedido = pedidoRepository.findById(id).orElseThrow();
            pedidoRepository.deleteById(id);

            return pedido;
        }catch (CustomException e){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
    }
}
