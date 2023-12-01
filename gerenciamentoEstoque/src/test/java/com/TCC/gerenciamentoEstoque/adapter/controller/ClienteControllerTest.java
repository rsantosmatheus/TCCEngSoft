package com.TCC.gerenciamentoEstoque.adapter.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ClienteDto;
import com.TCC.gerenciamentoEstoque.domain.model.Cliente;
import com.TCC.gerenciamentoEstoque.ports.input.ClientePort;
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

class ClienteControllerTest {

    @Mock
    private ClientePort clientePort;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllClientes() {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        clienteDtos.add(new ClienteDto());

        when(clientePort.getAllClientes()).thenReturn(clienteDtos);

        ResponseEntity<List<ClienteDto>> responseEntity = clienteController.getAllClientes();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetClienteByCnpj() {
        String cnpj = "12345678901234";
        ClienteDto clienteDto = new ClienteDto();

        when(clientePort.getClienteByCnpjCpf(cnpj)).thenReturn(clienteDto);

        ResponseEntity<ClienteDto> responseEntity = clienteController.getClienteByCnpj(cnpj);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testCreateCliente() {
        ClienteDto clienteDto = new ClienteDto();
        when(clientePort.createCliente(clienteDto)).thenReturn(new Cliente());

        ResponseEntity<?> responseEntity = clienteController.createCliente(clienteDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testUpdateClienteById() {
        Long id = 1L;
        ClienteDto clienteDto = new ClienteDto();
        when(clientePort.updateClienteById(id, clienteDto)).thenReturn(new Cliente());

        ResponseEntity<Cliente> responseEntity = clienteController.updateClienteById(id, clienteDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testDeleteClienteById() {
        Long id = 1L;
        when(clientePort.deleteClienteById(id)).thenReturn(new Cliente());

        ResponseEntity<Cliente> responseEntity = clienteController.deleteClienteById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }
}

