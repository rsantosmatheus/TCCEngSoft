package com.TCC.gerenciamentoEstoque.adapter.input.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.EstoqueDto;
import com.TCC.gerenciamentoEstoque.ports.input.EstoquePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Estoque")
public class EstoqueController {

    @Autowired
    EstoquePort estoquePort;

    @GetMapping
    public ResponseEntity<List<EstoqueDto>> getAllEstoque(){
        return ResponseEntity.ok(estoquePort.getAllEstoque());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueDto> getEstoqueById(@PathVariable Long id){
        return ResponseEntity.ok(estoquePort.getEstoqueById(id));
    }

    @GetMapping("/{codInternoProduto}")
    public ResponseEntity<EstoqueDto> getEstoqueByCodInternoProduto(@PathVariable int codInternoProduto){
        return ResponseEntity.ok(estoquePort.getProdutoByCodInternoProduto(codInternoProduto));
    }

    @GetMapping("/valorTotal")
    public ResponseEntity<String> getValorEstoque(){
        return ResponseEntity.ok(estoquePort.getValorEstoque());
    }

    @GetMapping("/valorPotencial")
    public ResponseEntity<String> getValorPotencialEstoque(){
        return ResponseEntity.ok(estoquePort.getValorPotecialEstoque());
    }

    /*Estoque é alterado através de pedidos e vendas, por isso não há métodos para manipulá-lo*/
}
