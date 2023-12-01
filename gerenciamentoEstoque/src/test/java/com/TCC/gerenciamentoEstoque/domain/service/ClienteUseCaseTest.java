package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ClienteDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ClienteMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Cliente;
import com.TCC.gerenciamentoEstoque.ports.output.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteUseCaseTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteUseCase clienteUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllClientes() throws CustomException {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = new Cliente();
        clientes.add(cliente);

        when(clienteRepository.findAll()).thenReturn(clientes);
        when(clienteMapper.clienteDtoMapper(cliente)).thenReturn(new ClienteDto());

        List<ClienteDto> clienteDtos = clienteUseCase.getAllClientes();

        assertNotNull(clienteDtos);
        assertFalse(clienteDtos.isEmpty());
    }

    @Test
    void testGetClienteByCnpjCpf() {
        String cnpjCpf = "123456789";

        Cliente cliente = new Cliente();
        cliente.setCnpjOuCpf(cnpjCpf);

        when(clienteRepository.findClienteByCnpjCpf(cnpjCpf)).thenReturn(cliente);
        when(clienteMapper.clienteDtoMapper(cliente)).thenReturn(new ClienteDto());

        ClienteDto clienteDto = clienteUseCase.getClienteByCnpjCpf(cnpjCpf);

        assertNotNull(clienteDto);
        assertEquals(cnpjCpf, clienteDto.getCnpjOuCpf());
    }

    @Test
    void testCreateCliente() throws CustomException {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setCnpjOuCpf("123456789");

        Cliente cliente = new Cliente();
        cliente.setCnpjOuCpf(clienteDto.getCnpjOuCpf());

        when(clienteRepository.findClienteByCnpjCpf(clienteDto.getCnpjOuCpf())).thenReturn(null);
        when(clienteMapper.clienteMapper(clienteDto)).thenReturn(cliente);

        Cliente createdCliente = clienteUseCase.createCliente(clienteDto);

        assertNotNull(createdCliente);
        assertEquals(clienteDto.getCnpjOuCpf(), createdCliente.getCnpjOuCpf());
    }

    @Test
    void testCreateClienteWhenAlreadyExists() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setCnpjOuCpf("123456789");

        Cliente existingCliente = new Cliente();
        existingCliente.setCnpjOuCpf(clienteDto.getCnpjOuCpf());

        when(clienteRepository.findClienteByCnpjCpf(clienteDto.getCnpjOuCpf())).thenReturn(existingCliente);

        assertThrows(CustomException.class, () -> clienteUseCase.createCliente(clienteDto));
    }

    @Test
    void testUpdateClienteById() throws CustomException {
        Long id = 1L;
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setCnpjOuCpf("123456789");

        Cliente existingCliente = new Cliente();
        existingCliente.setId(id);

        when(clienteRepository.findById(id)).thenReturn(Optional.of(existingCliente));
        when(clienteMapper.clienteMapper(clienteDto)).thenReturn(existingCliente);

        Cliente updatedCliente = clienteUseCase.updateClienteById(id, clienteDto);

        assertNotNull(updatedCliente);
        assertEquals(clienteDto.getCnpjOuCpf(), updatedCliente.getCnpjOuCpf());
    }

    @Test
    void testUpdateClienteByIdWhenNotFound() {
        Long id = 1L;

        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> clienteUseCase.updateClienteById(id, new ClienteDto()));
    }

    @Test
    void testDeleteClienteById() throws CustomException {
        Long id = 1L;
        Cliente existingCliente = new Cliente();
        existingCliente.setId(id);

        when(clienteRepository.findById(id)).thenReturn(Optional.of(existingCliente));

        Cliente deletedCliente = clienteUseCase.deleteClienteById(id);

        assertNotNull(deletedCliente);
        assertEquals(id, deletedCliente.getId());
    }

    @Test
    void testDeleteClienteByIdWhenNotFound() {
        Long id = 1L;

        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> clienteUseCase.deleteClienteById(id));
    }
}
