package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FornecedorDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FornecedorMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;
import com.TCC.gerenciamentoEstoque.ports.output.FornecedorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FornecedorUseCaseTest {

    @Mock
    private FornecedorRepository fornecedorRepository;

    @Mock
    private FornecedorMapper fornecedorMapper;

    @InjectMocks
    private FornecedorUseCase fornecedorUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        Fornecedor fornecedor = new Fornecedor();
        fornecedores.add(fornecedor);

        when(fornecedorRepository.findAll()).thenReturn(fornecedores);
        when(fornecedorMapper.fornecedorDtoMapper(fornecedor)).thenReturn(new FornecedorDto());

        List<FornecedorDto> fornecedorDtos = fornecedorUseCase.getAllFornecedores();

        assertNotNull(fornecedorDtos);
        assertFalse(fornecedorDtos.isEmpty());
    }

    @Test
    void testGetFornecedorByCnpj() {
        String cnpj = "12345678901234";

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj(cnpj);

        when(fornecedorRepository.findFornecedorByCnpj(cnpj)).thenReturn(fornecedor);
        when(fornecedorMapper.fornecedorDtoMapper(fornecedor)).thenReturn(new FornecedorDto());

        FornecedorDto fornecedorDto = fornecedorUseCase.getFornecedorByCnpj(cnpj);

        assertNotNull(fornecedorDto);
        assertEquals(cnpj, fornecedorDto.getCnpj());
    }

    @Test
    void testGetFornecedorByCnpjWhenNotFound() {
        String cnpj = "12345678901234";

        when(fornecedorRepository.findFornecedorByCnpj(cnpj)).thenReturn(new Fornecedor());

        assertThrows(CustomException.class, () -> fornecedorUseCase.getFornecedorByCnpj(cnpj));
    }

    @Test
    void testCreateFornecedor() throws CustomException {
        FornecedorDto fornecedorDto = new FornecedorDto();
        fornecedorDto.setCnpj("12345678901234");

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj(fornecedorDto.getCnpj());

        when(fornecedorRepository.findFornecedorByCnpj(fornecedorDto.getCnpj())).thenReturn(null);
        when(fornecedorMapper.fornecedorMapper(fornecedorDto)).thenReturn(fornecedor);

        Fornecedor createdFornecedor = fornecedorUseCase.createFornecedor(fornecedorDto);

        assertNotNull(createdFornecedor);
        assertEquals(fornecedorDto.getCnpj(), createdFornecedor.getCnpj());
    }

    @Test
    void testCreateFornecedorWhenAlreadyExists() {
        FornecedorDto fornecedorDto = new FornecedorDto();
        fornecedorDto.setCnpj("12345678901234");

        Fornecedor existingFornecedor = new Fornecedor();
        existingFornecedor.setCnpj(fornecedorDto.getCnpj());

        when(fornecedorRepository.findFornecedorByCnpj(fornecedorDto.getCnpj())).thenReturn(existingFornecedor);

        assertThrows(CustomException.class, () -> fornecedorUseCase.createFornecedor(fornecedorDto));
    }

    @Test
    void testUpdateFornecedorById() throws CustomException {
        Long id = 1L;
        FornecedorDto fornecedorDto = new FornecedorDto();
        fornecedorDto.setCnpj("12345678901234");

        Fornecedor existingFornecedor = new Fornecedor();
        existingFornecedor.setId(id);

        when(fornecedorRepository.findById(id)).thenReturn(Optional.of(existingFornecedor));
        when(fornecedorMapper.fornecedorMapper(fornecedorDto)).thenReturn(existingFornecedor);

        Fornecedor updatedFornecedor = fornecedorUseCase.updateFornecedorById(id, fornecedorDto);

        assertNotNull(updatedFornecedor);
        assertEquals(fornecedorDto.getCnpj(), updatedFornecedor.getCnpj());
    }

    @Test
    void testUpdateFornecedorByIdWhenNotFound() {
        Long id = 1L;

        when(fornecedorRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> fornecedorUseCase.updateFornecedorById(id, new FornecedorDto()));
    }

    @Test
    void testDeleteFornecedorById() throws CustomException {
        Long id = 1L;
        Fornecedor existingFornecedor = new Fornecedor();
        existingFornecedor.setId(id);

        when(fornecedorRepository.findById(id)).thenReturn(Optional.of(existingFornecedor));

        Fornecedor deletedFornecedor = fornecedorUseCase.deleteFornecedorById(id);

        assertNotNull(deletedFornecedor);
        assertEquals(id, deletedFornecedor.getId());
    }

    @Test
    void testDeleteFornecedorByIdWhenNotFound() {
        Long id = 1L;

        when(fornecedorRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> fornecedorUseCase.deleteFornecedorById(id));
    }
}

