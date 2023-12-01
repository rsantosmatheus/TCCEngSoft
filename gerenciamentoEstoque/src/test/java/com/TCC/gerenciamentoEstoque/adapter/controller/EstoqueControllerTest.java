package com.TCC.gerenciamentoEstoque.adapter.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.EstoqueDto;
import com.TCC.gerenciamentoEstoque.ports.input.EstoquePort;
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

class EstoqueControllerTest {

    @Mock
    private EstoquePort estoquePort;

    @InjectMocks
    private EstoqueController estoqueController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEstoque() {
        List<EstoqueDto> estoqueDtos = new ArrayList<>();
        estoqueDtos.add(new EstoqueDto());

        when(estoquePort.getAllEstoque()).thenReturn(estoqueDtos);

        ResponseEntity<List<EstoqueDto>> responseEntity = estoqueController.getAllEstoque();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetEstoqueById() {
        Long idEstoque = 1L;
        EstoqueDto estoqueDto = new EstoqueDto();

        when(estoquePort.getEstoqueById(idEstoque)).thenReturn(estoqueDto);

        ResponseEntity<EstoqueDto> responseEntity = estoqueController.getEstoqueById(idEstoque);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testGetEstoqueByCodInternoProduto() {
        int codInternoProduto = 123;

        EstoqueDto estoqueDto = new EstoqueDto();
        when(estoquePort.getProdutoByCodInternoProduto(codInternoProduto)).thenReturn(estoqueDto);

        ResponseEntity<EstoqueDto> responseEntity = estoqueController.getEstoqueByCodInternoProduto(codInternoProduto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testGetValorEstoque() {
        String valorEstoque = "1000.0";

        when(estoquePort.getValorEstoque()).thenReturn(valorEstoque);

        ResponseEntity<String> responseEntity = estoqueController.getValorEstoque();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(valorEstoque, responseEntity.getBody());
    }

    @Test
    void testGetValorPotencialEstoque() {
        String valorPotencialEstoque = "2000.0";

        when(estoquePort.getValorPotecialEstoque()).thenReturn(valorPotencialEstoque);

        ResponseEntity<String> responseEntity = estoqueController.getValorPotencialEstoque();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(valorPotencialEstoque, responseEntity.getBody());
    }
}
