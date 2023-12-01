package com.TCC.gerenciamentoEstoque.adapter.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ProdutoDto;
import com.TCC.gerenciamentoEstoque.domain.model.Produto;
import com.TCC.gerenciamentoEstoque.ports.input.ProdutoPort;
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

class ProdutoControllerTest {

    @Mock
    private ProdutoPort produtoPort;

    @InjectMocks
    private ProdutoController produtoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProdutos() {
        List<ProdutoDto> produtoDtos = new ArrayList<>();
        produtoDtos.add(new ProdutoDto());

        when(produtoPort.getAllProdutos()).thenReturn(produtoDtos);

        ResponseEntity<List<ProdutoDto>> responseEntity = produtoController.getAllProdutos();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetProdutoById() {
        Long id = 1L;
        ProdutoDto produtoDto = new ProdutoDto();

        when(produtoPort.getProdutoById(id)).thenReturn(produtoDto);

        ResponseEntity<ProdutoDto> responseEntity = produtoController.getProdutoById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testGetProdutoByNomeParecido() {
        String nameLike = "example";
        List<ProdutoDto> produtoDtos = new ArrayList<>();
        produtoDtos.add(new ProdutoDto());

        when(produtoPort.getProdutoByNomeParecido(nameLike)).thenReturn(produtoDtos);

        ResponseEntity<List<ProdutoDto>> responseEntity = produtoController.getProdutoByNomeParecido(nameLike);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetProdutoByCodigoInterno() {
        int codInternoProduto = 123;
        List<ProdutoDto> produtoDtos = new ArrayList<>();
        produtoDtos.add(new ProdutoDto());

        when(produtoPort.getProdutoByCodigoInterno(codInternoProduto)).thenReturn(produtoDtos);

        ResponseEntity<List<ProdutoDto>> responseEntity = produtoController.getProdutoByCodigoInterno(codInternoProduto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testCreateProduto() {
        ProdutoDto produtoDto = new ProdutoDto();
        when(produtoPort.createProduto(produtoDto)).thenReturn(new Produto());

        ResponseEntity<Produto> responseEntity = produtoController.createProduto(produtoDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testUpdateProdutoById() {
        Long id = 1L;
        ProdutoDto produtoDto = new ProdutoDto();
        when(produtoPort.updateProdutoById(id, produtoDto)).thenReturn(new Produto());

        ResponseEntity<Produto> responseEntity = produtoController.updateProdutoById(id, produtoDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testDeleteProdutoById() {
        Long id = 1L;
        when(produtoPort.deleteProdutoById(id)).thenReturn(new Produto());

        ResponseEntity<Produto> responseEntity = produtoController.deleteProdutoById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }
}
