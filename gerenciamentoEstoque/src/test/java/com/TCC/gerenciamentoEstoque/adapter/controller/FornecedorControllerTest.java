package com.TCC.gerenciamentoEstoque.adapter.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FornecedorDto;
import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;
import com.TCC.gerenciamentoEstoque.ports.input.FornecedorPort;
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

class FornecedorControllerTest {

    @Mock
    private FornecedorPort fornecedorPort;

    @InjectMocks
    private FornecedorController fornecedorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllFornecedores() {
        List<FornecedorDto> fornecedorDtos = new ArrayList<>();
        fornecedorDtos.add(new FornecedorDto());

        when(fornecedorPort.getAllFornecedores()).thenReturn(fornecedorDtos);

        ResponseEntity<List<FornecedorDto>> responseEntity = fornecedorController.getAllFornecedores();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetFornecedorByCnpj() {
        String cnpj = "12345678901234";
        FornecedorDto fornecedorDto = new FornecedorDto();

        when(fornecedorPort.getFornecedorByCnpj(cnpj)).thenReturn(fornecedorDto);

        ResponseEntity<FornecedorDto> responseEntity = fornecedorController.getFornecedorByCnpj(cnpj);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testCreateFornecedor() {
        FornecedorDto fornecedorDto = new FornecedorDto();
        when(fornecedorPort.createFornecedor(fornecedorDto)).thenReturn(new Fornecedor());

        ResponseEntity<Fornecedor> responseEntity = fornecedorController.createFornecedor(fornecedorDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testUpdateFornecedorById() {
        Long id = 1L;
        FornecedorDto fornecedorDto = new FornecedorDto();
        when(fornecedorPort.updateFornecedorById(id, fornecedorDto)).thenReturn(new Fornecedor());

        ResponseEntity<Fornecedor> responseEntity = fornecedorController.updateFornecedorById(id, fornecedorDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testDeleteFornecedorById() {
        Long id = 1L;
        when(fornecedorPort.deleteFornecedorById(id)).thenReturn(new Fornecedor());

        ResponseEntity<Fornecedor> responseEntity = fornecedorController.deleteFornecedorById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }
}

