package com.TCC.gerenciamentoEstoque.adapter.input.controller;


import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.FornecedorDto;
import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;
import com.TCC.gerenciamentoEstoque.ports.input.FornecedorPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorPort fornecedorPort;

    @GetMapping
    public ResponseEntity<List<FornecedorDto>> getAllFornecedores(){
        return ResponseEntity.ok(fornecedorPort.getAllFornecedores());
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<FornecedorDto> getFornecedorByCnpj(@PathVariable String cnpj){
        return ResponseEntity.ok(fornecedorPort.getFornecedorByCnpj(cnpj));
    }

    @PostMapping
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody FornecedorDto fornecedorDto){
        return ResponseEntity.ok(fornecedorPort.createFornecedor(fornecedorDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Fornecedor>> updateFornecedorById(@PathVariable Long id, @RequestBody FornecedorDto fornecedorDto){
        return ResponseEntity.ok(fornecedorPort.updateFornecedorById(id, fornecedorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Fornecedor>> deleteFornecedorById(@PathVariable Long id){
        return ResponseEntity.ok(fornecedorPort.deleteFornecedorById(id));
    }
}
