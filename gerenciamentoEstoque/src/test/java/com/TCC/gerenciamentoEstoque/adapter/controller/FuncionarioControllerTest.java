package com.TCC.gerenciamentoEstoque.adapter.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FuncionarioDto;
import com.TCC.gerenciamentoEstoque.domain.model.Funcionario;
import com.TCC.gerenciamentoEstoque.ports.input.FuncionarioPort;
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

class FuncionarioControllerTest {

    @Mock
    private FuncionarioPort funcionarioPort;

    @InjectMocks
    private FuncionarioController funcionarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllFuncionarios() {
        List<FuncionarioDto> funcionarioDtos = new ArrayList<>();
        funcionarioDtos.add(new FuncionarioDto());

        when(funcionarioPort.getAllFuncionarios()).thenReturn(funcionarioDtos);

        ResponseEntity<List<FuncionarioDto>> responseEntity = funcionarioController.getAllFuncionarios();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetFuncionarioByCpf() {
        String cpf = "12345678901";
        FuncionarioDto funcionarioDto = new FuncionarioDto();

        when(funcionarioPort.getFuncionarioByCpf(cpf)).thenReturn(funcionarioDto);

        ResponseEntity<FuncionarioDto> responseEntity = funcionarioController.getFuncionarioByCpf(cpf);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testCreateFuncionario() {
        FuncionarioDto funcionarioDto = new FuncionarioDto();
        when(funcionarioPort.createFuncionario(funcionarioDto)).thenReturn(new Funcionario());

        ResponseEntity<Funcionario> responseEntity = funcionarioController.createFuncionario(funcionarioDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testUpdateFuncionarioById() {
        Long id = 1L;
        FuncionarioDto funcionarioDto = new FuncionarioDto();
        when(funcionarioPort.updateFuncionario(id, funcionarioDto)).thenReturn(new Funcionario());

        ResponseEntity<Funcionario> responseEntity = funcionarioController.updateFuncionarioById(id, funcionarioDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testDeleteFuncionarioById() {
        Long id = 1L;
        when(funcionarioPort.deleteFuncionarioById(id)).thenReturn(new Funcionario());

        ResponseEntity<Funcionario> responseEntity = funcionarioController.deleteFuncionarioById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }
}
