package com.TCC.gerenciamentoEstoque.adapter.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.VendaDto;
import com.TCC.gerenciamentoEstoque.domain.model.Venda;
import com.TCC.gerenciamentoEstoque.ports.input.VendaPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VendaControllerTest {

    @Mock
    private VendaPort vendaPort;

    @InjectMocks
    private VendaController vendaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllVendas() {
        List<VendaDto> vendaDtos = new ArrayList<>();
        vendaDtos.add(new VendaDto());

        when(vendaPort.getAllVendas()).thenReturn(vendaDtos);

        ResponseEntity<List<VendaDto>> responseEntity = vendaController.getAllVendas();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetVendasByDatas() {
        Date startDate = new Date();
        Date endDate = new Date();

        List<VendaDto> vendaDtos = new ArrayList<>();
        vendaDtos.add(new VendaDto());

        when(vendaPort.getVendasByDates(startDate, endDate)).thenReturn(vendaDtos);

        ResponseEntity<List<VendaDto>> responseEntity = vendaController.getVendasByDatas(startDate, endDate);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetVendasByClienteAndData() {
        Long idCliente = 1L;
        Date startDate = new Date();
        Date endDate = new Date();

        List<VendaDto> vendaDtos = new ArrayList<>();
        vendaDtos.add(new VendaDto());

        when(vendaPort.getVendasByCliente(idCliente, startDate, endDate)).thenReturn(vendaDtos);

        ResponseEntity<List<VendaDto>> responseEntity = vendaController.getVendasByClienteAndData(idCliente, startDate, endDate);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

    @Test
    void testGetVendasById() {
        Long idVenda = 1L;
        VendaDto vendaDto = new VendaDto();

        when(vendaPort.getVendasById(idVenda)).thenReturn(vendaDto);

        ResponseEntity<VendaDto> responseEntity = vendaController.getVendasById(idVenda);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testCreateVenda() {
        VendaDto vendaDto = new VendaDto();
        when(vendaPort.createVenda(vendaDto)).thenReturn(new Venda());

        ResponseEntity<Venda> responseEntity = vendaController.createVenda(vendaDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testUpdateVenda() {
        Long idVenda = 1L;
        VendaDto vendaDto = new VendaDto();

        when(vendaPort.updateVenda(idVenda, vendaDto)).thenReturn(new Venda());

        ResponseEntity<Venda> responseEntity = vendaController.updateVenda(idVenda, vendaDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testDeleteVenda() {
        Long idVenda = 1L;
        when(vendaPort.deleteVenda(idVenda)).thenReturn(new Venda());

        ResponseEntity<Venda> responseEntity = vendaController.deleteVenda(idVenda);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }
}
