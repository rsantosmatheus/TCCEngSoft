package com.TCC.gerenciamentoEstoque.adapter.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.PedidoDto;
import com.TCC.gerenciamentoEstoque.domain.model.Pedido;
import com.TCC.gerenciamentoEstoque.ports.input.PedidoPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoControllerTest {

    @Mock
    private PedidoPort pedidoPort;

    @InjectMocks
    private PedidoController pedidoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPedidos() {
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        pedidoDtos.add(new PedidoDto());

        when(pedidoPort.getAllPedidos()).thenReturn(pedidoDtos);

        ResponseEntity<List<PedidoDto>> responseEntity = pedidoController.getAllPedidos();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetAllPedidosByIdProduto() {
        Long idProduto = 1L;
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        pedidoDtos.add(new PedidoDto());

        when(pedidoPort.getAllPedidosByIdProduto(idProduto)).thenReturn(pedidoDtos);

        ResponseEntity<List<PedidoDto>> responseEntity = pedidoController.getAllPedidosByIdProduto(idProduto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetAllPedidosByIdFornecedor() {
        Long idFornecedor = 1L;
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        pedidoDtos.add(new PedidoDto());

        when(pedidoPort.getAllPedidosByIdFornecedor(idFornecedor)).thenReturn(pedidoDtos);

        ResponseEntity<List<PedidoDto>> responseEntity = pedidoController.getAllPedidosByIdFornecedor(idFornecedor);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetAllPedidosByIdFuncionario() {
        Long idFuncionario = 1L;
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        pedidoDtos.add(new PedidoDto());

        when(pedidoPort.getAllPedidosByIdFuncionario(idFuncionario)).thenReturn(pedidoDtos);

        ResponseEntity<List<PedidoDto>> responseEntity = pedidoController.getAllPedidosByIdFuncionario(idFuncionario);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetPedidoById() {
        Long idPedido = 1L;
        PedidoDto pedidoDto = new PedidoDto();

        when(pedidoPort.getPedidoById(idPedido)).thenReturn(pedidoDto);

        ResponseEntity<PedidoDto> responseEntity = pedidoController.getPedidoById(idPedido);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testCreatePedido() {
        PedidoDto pedidoDto = new PedidoDto();
        when(pedidoPort.createPedido(pedidoDto)).thenReturn(new Pedido());

        ResponseEntity<Pedido> responseEntity = pedidoController.createPedido(pedidoDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testUpdatePedido() {
        Long idPedido = 1L;
        PedidoDto pedidoDto = new PedidoDto();

        when(pedidoPort.updatePedido(idPedido, pedidoDto)).thenReturn(new Pedido());

        ResponseEntity<Pedido> responseEntity = pedidoController.updatePedido(idPedido, pedidoDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testDeletePedidoById() {
        Long idPedido = 1L;
        when(pedidoPort.deletePedidoById(idPedido)).thenReturn(new Pedido());

        ResponseEntity<Pedido> responseEntity = pedidoController.deletePedidoById(idPedido);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }
}
