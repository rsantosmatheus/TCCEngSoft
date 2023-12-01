package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FuncionarioDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FuncionarioMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Funcionario;
import com.TCC.gerenciamentoEstoque.ports.output.FuncionarioRepository;
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

class FuncionarioUseCaseTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Mock
    private FuncionarioMapper funcionarioMapper;

    @InjectMocks
    private FuncionarioUseCase funcionarioUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario = new Funcionario();
        funcionarios.add(funcionario);

        when(funcionarioRepository.findAll()).thenReturn(funcionarios);
        when(funcionarioMapper.funcionarioDtoMapper(funcionario)).thenReturn(new FuncionarioDto());

        List<FuncionarioDto> funcionarioDtos = funcionarioUseCase.getAllFuncionarios();

        assertNotNull(funcionarioDtos);
        assertFalse(funcionarioDtos.isEmpty());
    }

    @Test
    void testGetFuncionarioByCpf() {
        String cpf = "123456789";

        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(cpf);

        when(funcionarioRepository.findFuncionarioByCpf(cpf)).thenReturn(funcionario);
        when(funcionarioMapper.funcionarioDtoMapper(funcionario)).thenReturn(new FuncionarioDto());

        FuncionarioDto funcionarioDto = funcionarioUseCase.getFuncionarioByCpf(cpf);

        assertNotNull(funcionarioDto);
        assertEquals(cpf, funcionarioDto.getCpf());
    }

    @Test
    void testGetFuncionarioByCpfWhenNotFound() {
        String cpf = "123456789";

        when(funcionarioRepository.findFuncionarioByCpf(cpf)).thenReturn(new Funcionario());

        assertThrows(CustomException.class, () -> funcionarioUseCase.getFuncionarioByCpf(cpf));
    }

    @Test
    void testCreateFuncionario() throws CustomException {
        FuncionarioDto funcionarioDto = new FuncionarioDto();
        funcionarioDto.setCpf("123456789");

        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(funcionarioDto.getCpf());

        when(funcionarioRepository.findFuncionarioByCpf(funcionarioDto.getCpf())).thenReturn(null);
        when(funcionarioMapper.funcionarioMapper(funcionarioDto)).thenReturn(funcionario);

        Funcionario createdFuncionario = funcionarioUseCase.createFuncionario(funcionarioDto);

        assertNotNull(createdFuncionario);
        assertEquals(funcionarioDto.getCpf(), createdFuncionario.getCpf());
    }

    @Test
    void testCreateFuncionarioWhenAlreadyExists() {
        FuncionarioDto funcionarioDto = new FuncionarioDto();
        funcionarioDto.setCpf("123456789");

        Funcionario existingFuncionario = new Funcionario();
        existingFuncionario.setCpf(funcionarioDto.getCpf());

        when(funcionarioRepository.findFuncionarioByCpf(funcionarioDto.getCpf())).thenReturn(existingFuncionario);

        assertThrows(CustomException.class, () -> funcionarioUseCase.createFuncionario(funcionarioDto));
    }

    @Test
    void testUpdateFuncionario() throws CustomException {
        Long id = 1L;
        FuncionarioDto funcionarioDto = new FuncionarioDto();
        funcionarioDto.setCpf("123456789");

        Funcionario existingFuncionario = new Funcionario();
        existingFuncionario.setId(id);

        when(funcionarioRepository.findById(id)).thenReturn(Optional.of(existingFuncionario));
        when(funcionarioMapper.funcionarioMapper(funcionarioDto)).thenReturn(existingFuncionario);

        Funcionario updatedFuncionario = funcionarioUseCase.updateFuncionario(id, funcionarioDto);

        assertNotNull(updatedFuncionario);
        assertEquals(funcionarioDto.getCpf(), updatedFuncionario.getCpf());
    }

    @Test
    void testUpdateFuncionarioWhenNotFound() {
        Long id = 1L;

        when(funcionarioRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> funcionarioUseCase.updateFuncionario(id, new FuncionarioDto()));
    }

    @Test
    void testDeleteFuncionarioById() throws CustomException {
        Long id = 1L;
        Funcionario existingFuncionario = new Funcionario();
        existingFuncionario.setId(id);

        when(funcionarioRepository.findById(id)).thenReturn(Optional.of(existingFuncionario));

        Funcionario deletedFuncionario = funcionarioUseCase.deleteFuncionarioById(id);

        assertNotNull(deletedFuncionario);
        assertEquals(id, deletedFuncionario.getId());
    }

    @Test
    void testDeleteFuncionarioByIdWhenNotFound() {
        Long id = 1L;

        when(funcionarioRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> funcionarioUseCase.deleteFuncionarioById(id));
    }
}