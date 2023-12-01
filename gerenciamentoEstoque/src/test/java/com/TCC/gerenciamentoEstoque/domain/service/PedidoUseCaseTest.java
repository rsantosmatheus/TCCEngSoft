package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.PedidoDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ProdutoDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.PedidoMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ProdutoMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Estoque;
import com.TCC.gerenciamentoEstoque.domain.model.Pedido;
import com.TCC.gerenciamentoEstoque.domain.model.Produto;
import com.TCC.gerenciamentoEstoque.ports.output.EstoqueRepository;
import com.TCC.gerenciamentoEstoque.ports.output.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoUseCaseTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private PedidoMapper pedidoMapper;

    @Mock
    private ProdutoMapper produtoMapper;

    @Mock
    private EstoqueRepository estoqueRepository;

    @InjectMocks
    private PedidoUseCase pedidoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = new Pedido();
        pedidos.add(pedido);

        when(pedidoRepository.findAll()).thenReturn(pedidos);
        when(pedidoMapper.pedidoDtoMapper(pedido)).thenReturn(new PedidoDto());

        List<PedidoDto> pedidoDtos = pedidoUseCase.getAllPedidos();

        assertNotNull(pedidoDtos);
        assertFalse(pedidoDtos.isEmpty());
    }

    @Test
    void testGetAllPedidosByIdProduto() {
        Long idProduto = 1L;
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = new Pedido();
        pedidos.add(pedido);

        when(pedidoRepository.findPedidoByProdudoId(idProduto)).thenReturn(pedidos);
        when(pedidoMapper.pedidoDtoMapper(pedido)).thenReturn(new PedidoDto());

        List<PedidoDto> pedidoDtos = pedidoUseCase.getAllPedidosByIdProduto(idProduto);

        assertNotNull(pedidoDtos);
        assertFalse(pedidoDtos.isEmpty());
    }

    @Test
    void testGetAllPedidosByIdFornecedor() {
        Long idFornecedor = 1L;
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = new Pedido();
        pedidos.add(pedido);

        when(pedidoRepository.findPedidoByFornecedorId(idFornecedor)).thenReturn(pedidos);
        when(pedidoMapper.pedidoDtoMapper(pedido)).thenReturn(new PedidoDto());

        List<PedidoDto> pedidoDtos = pedidoUseCase.getAllPedidosByIdFornecedor(idFornecedor);

        assertNotNull(pedidoDtos);
        assertFalse(pedidoDtos.isEmpty());
    }

    @Test
    void testGetAllPedidosByIdFuncionario() {
        Long idFuncionario = 1L;
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = new Pedido();
        pedidos.add(pedido);

        when(pedidoRepository.findPedidoByFuncionarioId(idFuncionario)).thenReturn(pedidos);
        when(pedidoMapper.pedidoDtoMapper(pedido)).thenReturn(new PedidoDto());

        List<PedidoDto> pedidoDtos = pedidoUseCase.getAllPedidosByIdFuncionario(idFuncionario);

        assertNotNull(pedidoDtos);
        assertFalse(pedidoDtos.isEmpty());
    }

    @Test
    void testGetPedidoById() {
        Long id = 1L;
        Pedido pedido = new Pedido();
        pedido.setId(id);

        when(pedidoRepository.findById(id)).thenReturn(Optional.of(pedido));
        when(pedidoMapper.pedidoDtoMapper(pedido)).thenReturn(new PedidoDto());

        PedidoDto pedidoDto = pedidoUseCase.getPedidoById(id);

        assertNotNull(pedidoDto);
        assertEquals(id, pedidoDto.getId());
    }

    @Test
    void testCreatePedido() {
        PedidoDto pedidoDto = new PedidoDto();
        Pedido pedido = new Pedido();
        Estoque estoque = new Estoque();

        when(pedidoMapper.pedidoMapper(pedidoDto)).thenReturn(pedido);
        when(estoqueRepository.findEstoqueByCodInterno(pedido.getProduto().getCodInterno())).thenReturn(estoque);

        Pedido createdPedido = pedidoUseCase.createPedido(pedidoDto);

        assertNotNull(createdPedido);
    }

    @Test
    void testUpdatePedido() {
        Long id = 1L;
        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setProduto(new ProdutoDto());
        Pedido existingPedido = new Pedido();
        existingPedido.setId(id);

        when(pedidoRepository.findById(id)).thenReturn(Optional.of(existingPedido));
        when(produtoMapper.produtoMapper(pedidoDto.getProduto())).thenReturn(new Produto());
        when(estoqueRepository.findEstoqueByCodInterno(pedidoDto.getProduto().getCodInterno())).thenReturn(new Estoque());

        Pedido updatedPedido = pedidoUseCase.updatePedido(id, pedidoDto);

        assertNotNull(updatedPedido);
        assertEquals(id, updatedPedido.getId());
    }

    @Test
    void testDeletePedidoById() {
        Long id = 1L;
        Pedido existingPedido = new Pedido();
        existingPedido.setId(id);

        when(pedidoRepository.findById(id)).thenReturn(Optional.of(existingPedido));

        Pedido deletedPedido = pedidoUseCase.deletePedidoById(id);

        assertNotNull(deletedPedido);
        assertEquals(id, deletedPedido.getId());
    }

    // Testes de exceção

    @Test
    void testGetAllPedidosEmptyList() {
        when(pedidoRepository.findAll()).thenReturn(new ArrayList<>());

        assertThrows(CustomException.class, () -> pedidoUseCase.getAllPedidos());
    }

    @Test
    void testGetPedidoByIdNotFound() {
        Long id = 1L;
        when(pedidoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> pedidoUseCase.getPedidoById(id));
    }

    @Test
    void testUpdatePedidoNotFound() {
        Long id = 1L;
        when(pedidoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> pedidoUseCase.updatePedido(id, new PedidoDto()));
    }

    @Test
    void testDeletePedidoByIdNotFound() {
        Long id = 1L;
        when(pedidoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> pedidoUseCase.deletePedidoById(id));
    }
}
