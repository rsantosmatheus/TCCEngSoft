package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ProdutoDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.VendaDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ClienteMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FuncionarioMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ProdutoMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.VendaMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Estoque;
import com.TCC.gerenciamentoEstoque.domain.model.Produto;
import com.TCC.gerenciamentoEstoque.domain.model.Venda;
import com.TCC.gerenciamentoEstoque.ports.output.EstoqueRepository;
import com.TCC.gerenciamentoEstoque.ports.output.VendaRepository;
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

class VendaUseCaseTest {

    @Mock
    private VendaRepository vendaRepository;

    @Mock
    private VendaMapper vendaMapper;

    @Mock
    private EstoqueRepository estoqueRepository;

    @Mock
    private FuncionarioMapper funcionarioMapper;

    @Mock
    private ClienteMapper clienteMapper;

    @Mock
    private ProdutoMapper produtoMapper;

    @InjectMocks
    private VendaUseCase vendaUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllVendas() {
        List<Venda> vendas = new ArrayList<>();
        Venda venda = new Venda();
        vendas.add(venda);

        when(vendaRepository.findAll()).thenReturn(vendas);
        when(vendaMapper.vendaDtoMapper(venda)).thenReturn(new VendaDto());

        List<VendaDto> vendaDtos = vendaUseCase.getAllVendas();

        assertNotNull(vendaDtos);
        assertFalse(vendaDtos.isEmpty());
    }

    @Test
    void testGetVendasByDates() {
        Date startDate = new Date();
        Date endDate = new Date();

        List<Venda> vendas = new ArrayList<>();
        Venda venda = new Venda();
        vendas.add(venda);

        when(vendaRepository.getVendasByDates(startDate, endDate)).thenReturn(vendas);
        when(vendaMapper.vendaDtoMapper(venda)).thenReturn(new VendaDto());

        List<VendaDto> vendaDtos = vendaUseCase.getVendasByDates(startDate, endDate);

        assertNotNull(vendaDtos);
        assertFalse(vendaDtos.isEmpty());
    }

    // Adicione outros testes conforme necessário

    @Test
    void testCreateVenda() {
        VendaDto vendaDto = new VendaDto();
        Venda venda = new Venda();
        Estoque estoque = new Estoque();

        when(vendaMapper.vendaMapper(vendaDto)).thenReturn(venda);
        when(estoqueRepository.findEstoqueByCodInterno(vendaDto.getProduto().getCodInterno())).thenReturn(estoque);

        Venda createdVenda = vendaUseCase.createVenda(vendaDto);

        assertNotNull(createdVenda);
    }

    // Adicione outros testes conforme necessário

    @Test
    void testUpdateVenda() {
        Long id = 1L;
        VendaDto vendaDto = new VendaDto();
        vendaDto.setProduto(new ProdutoDto());
        Venda existingVenda = new Venda();
        existingVenda.setId(id);

        when(vendaRepository.findById(id)).thenReturn(Optional.of(existingVenda));
        when(produtoMapper.produtoMapper(vendaDto.getProduto())).thenReturn(new Produto());
        when(estoqueRepository.findEstoqueByCodInterno(vendaDto.getProduto().getCodInterno())).thenReturn(new Estoque());

        Venda updatedVenda = vendaUseCase.updateVenda(id, vendaDto);

        assertNotNull(updatedVenda);
        assertEquals(id, updatedVenda.getId());
    }

    // Adicione outros testes conforme necessário

    @Test
    void testDeleteVenda() {
        Long id = 1L;
        Venda existingVenda = new Venda();
        existingVenda.setId(id);

        when(vendaRepository.findById(id)).thenReturn(Optional.of(existingVenda));

        Venda deletedVenda = vendaUseCase.deleteVenda(id);

        assertNotNull(deletedVenda);
        assertEquals(id, deletedVenda.getId());
    }

}
