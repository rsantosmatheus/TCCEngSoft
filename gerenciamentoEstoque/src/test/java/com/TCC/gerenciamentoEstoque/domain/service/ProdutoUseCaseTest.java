package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FornecedorDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ProdutoDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FornecedorMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ProdutoMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;
import com.TCC.gerenciamentoEstoque.domain.model.Produto;
import com.TCC.gerenciamentoEstoque.ports.output.ProdutoRepository;
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

class ProdutoUseCaseTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ProdutoMapper produtoMapper;

    @Mock
    private FornecedorMapper fornecedorMapper;

    @InjectMocks
    private ProdutoUseCase produtoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProdutos() {
        List<Produto> produtos = new ArrayList<>();
        Produto produto = new Produto();
        produtos.add(produto);

        when(produtoRepository.findAll()).thenReturn(produtos);
        when(produtoMapper.produtoDtoMapper(produto)).thenReturn(new ProdutoDto());

        List<ProdutoDto> produtoDtos = produtoUseCase.getAllProdutos();

        assertNotNull(produtoDtos);
        assertFalse(produtoDtos.isEmpty());
    }

    @Test
    void testGetProdutoById() {
        Long id = 1L;
        Produto produto = new Produto();
        produto.setId(id);

        when(produtoRepository.findById(id)).thenReturn(Optional.of(produto));
        when(produtoMapper.produtoDtoMapper(produto)).thenReturn(new ProdutoDto());

        ProdutoDto produtoDto = produtoUseCase.getProdutoById(id);

        assertNotNull(produtoDto);
        assertEquals(id, produtoDto.getId());
    }

    @Test
    void testGetProdutoByIdWhenNotFound() {
        Long id = 1L;

        when(produtoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> produtoUseCase.getProdutoById(id));
    }

    @Test
    void testGetProdutoByNomeParecido() {
        String nameLike = "produto";

        List<Produto> produtos = new ArrayList<>();
        Produto produto = new Produto();
        produtos.add(produto);

        when(produtoRepository.findProdutoByNomeLike(nameLike)).thenReturn(produtos);
        when(produtoMapper.produtoDtoMapper(produto)).thenReturn(new ProdutoDto());

        List<ProdutoDto> produtoDtos = produtoUseCase.getProdutoByNomeParecido(nameLike);

        assertNotNull(produtoDtos);
        assertFalse(produtoDtos.isEmpty());
    }

    @Test
    void testGetProdutoByNomeParecidoWhenNotFound() {
        String nameLike = "produto";

        when(produtoRepository.findProdutoByNomeLike(nameLike)).thenReturn(new ArrayList<>());

        assertThrows(CustomException.class, () -> produtoUseCase.getProdutoByNomeParecido(nameLike));
    }

    @Test
    void testCreateProduto() throws CustomException {
        ProdutoDto produtoDto = new ProdutoDto();
        Produto produto = new Produto();

        when(produtoMapper.produtoMapper(produtoDto)).thenReturn(produto);

        Produto createdProduto = produtoUseCase.createProduto(produtoDto);

        assertNotNull(createdProduto);
    }

    @Test
    void testUpdateProdutoById() throws CustomException {
        Long id = 1L;
        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setFornecedor(new FornecedorDto());

        Produto existingProduto = new Produto();
        existingProduto.setId(id);

        when(produtoRepository.findById(id)).thenReturn(Optional.of(existingProduto));
        when(fornecedorMapper.fornecedorMapper(produtoDto.getFornecedor())).thenReturn(new Fornecedor());

        Produto updatedProduto = produtoUseCase.updateProdutoById(id, produtoDto);

        assertNotNull(updatedProduto);
        assertEquals(id, updatedProduto.getId());
    }

    @Test
    void testUpdateProdutoByIdWhenNotFound() {
        Long id = 1L;

        when(produtoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> produtoUseCase.updateProdutoById(id, new ProdutoDto()));
    }

    @Test
    void testDeleteProdutoById() throws CustomException {
        Long id = 1L;
        Produto existingProduto = new Produto();
        existingProduto.setId(id);

        when(produtoRepository.findById(id)).thenReturn(Optional.of(existingProduto));

        Produto deletedProduto = produtoUseCase.deleteProdutoById(id);

        assertNotNull(deletedProduto);
        assertEquals(id, deletedProduto.getId());
    }

    @Test
    void testDeleteProdutoByIdWhenNotFound() {
        Long id = 1L;

        when(produtoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> produtoUseCase.deleteProdutoById(id));
    }
}
