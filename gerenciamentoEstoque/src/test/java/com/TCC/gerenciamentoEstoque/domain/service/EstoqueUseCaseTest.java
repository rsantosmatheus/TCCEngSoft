package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.EstoqueDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.EstoqueMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Estoque;
import com.TCC.gerenciamentoEstoque.ports.output.EstoqueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EstoqueUseCaseTest {

    @Mock
    private EstoqueRepository estoqueRepository;

    @Mock
    private EstoqueMapper estoqueMapper;

    @InjectMocks
    private EstoqueUseCase estoqueUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEstoque() {
        List<Estoque> estoques = new ArrayList<>();
        Estoque estoque = new Estoque();
        estoques.add(estoque);

        when(estoqueRepository.findAll()).thenReturn(estoques);
        when(estoqueMapper.estoqueDtoMapper(estoque)).thenReturn(new EstoqueDto());

        List<EstoqueDto> estoqueDtos = estoqueUseCase.getAllEstoque();

        assertNotNull(estoqueDtos);
        assertFalse(estoqueDtos.isEmpty());
    }

    @Test
    void testGetEstoqueById() {
        Long id = 1L;
        Estoque estoque = new Estoque();
        estoque.setId(id);

        when(estoqueRepository.findById(id)).thenReturn(Optional.of(estoque));
        when(estoqueMapper.estoqueDtoMapper(estoque)).thenReturn(new EstoqueDto());

        EstoqueDto estoqueDto = estoqueUseCase.getEstoqueById(id);

        assertNotNull(estoqueDto);
        assertEquals(id, estoqueDto.getId());
    }

    @Test
    void testGetValorEstoque() {
        Double valorEstoque = 1000.0;

        when(estoqueRepository.somarValorCompraProdutosEmEstoque()).thenReturn(BigDecimal.valueOf(valorEstoque));

        String resultado = estoqueUseCase.getValorEstoque();

        assertNotNull(resultado);
        assertEquals(valorEstoque.toString(), resultado);
    }

    @Test
    void testGetValorPotecialEstoque() {
        Double valorPotencialEstoque = 1500.0;

        when(estoqueRepository.somarValorVendaProdutosEmEstoque()).thenReturn(BigDecimal.valueOf(valorPotencialEstoque));

        String resultado = estoqueUseCase.getValorPotecialEstoque();

        assertNotNull(resultado);
        assertEquals(valorPotencialEstoque.toString(), resultado);
    }

    // Testes de exceção

    @Test
    void testGetAllEstoqueEmptyList() {
        when(estoqueRepository.findAll()).thenReturn(new ArrayList<>());

        assertThrows(CustomException.class, () -> estoqueUseCase.getAllEstoque());
    }

    @Test
    void testGetEstoqueByIdNotFound() {
        Long id = 1L;
        when(estoqueRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> estoqueUseCase.getEstoqueById(id));
    }

    @Test
    void testGetProdutoByCodInternoProdutoNotFound() {
        int codInternoProduto = 123;
        when(estoqueRepository.findEstoqueByCodInterno(codInternoProduto)).thenReturn(null);

        assertThrows(CustomException.class, () -> estoqueUseCase.getProdutoByCodInternoProduto(codInternoProduto));
    }
}

