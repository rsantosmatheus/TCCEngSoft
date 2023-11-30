package com.TCC.gerenciamentoEstoque.adapter.input.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FuncionarioDto;
import com.TCC.gerenciamentoEstoque.domain.model.Funcionario;
import com.TCC.gerenciamentoEstoque.ports.input.FuncionarioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioPort funcionarioPort;

    @GetMapping
    public ResponseEntity<List<FuncionarioDto>> getAllFuncionarios(){
        return ResponseEntity.ok(funcionarioPort.getAllFuncionarios());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<FuncionarioDto> getFuncionarioByCpf(@PathVariable String cpf){
        return ResponseEntity.ok(funcionarioPort.getFuncionarioByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody FuncionarioDto funcionarioDto){
        return ResponseEntity.ok(funcionarioPort.createFuncionario(funcionarioDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionarioById(@PathVariable Long id, @RequestBody FuncionarioDto funcionarioDto){
        return ResponseEntity.ok(funcionarioPort.updateFuncionario(id, funcionarioDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deleteFuncionarioById(@PathVariable Long id){
        return ResponseEntity.ok(funcionarioPort.deleteFuncionarioById(id));
    }
}
