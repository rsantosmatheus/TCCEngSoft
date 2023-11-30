package com.TCC.gerenciamentoEstoque.adapter.input.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ProdutoDto;
import com.TCC.gerenciamentoEstoque.domain.model.Produto;
import com.TCC.gerenciamentoEstoque.ports.input.ProdutoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoPort produtoPort;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> getAllProdutos(){
        return ResponseEntity.ok(produtoPort.getAllProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> getProdutoById(@PathVariable Long id){
        return ResponseEntity.ok(produtoPort.getProdutoById(id));
    }

    @GetMapping("/{nameLike}")
    public ResponseEntity<List<ProdutoDto>> getProdutoByNomeParecido(@PathVariable String nameLike){
        return ResponseEntity.ok(produtoPort.getProdutoByNomeParecido(nameLike));
    }

    @GetMapping("/{codInternoProduto}")
    public ResponseEntity <List<ProdutoDto>> getProdutoByCodigoInterno(@PathVariable int codInternoProduto){
        return ResponseEntity.ok(produtoPort.getProdutoByCodigoInterno(codInternoProduto));
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody ProdutoDto produtoDto){
        return ResponseEntity.ok(produtoPort.createProduto(produtoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProdutoById(@PathVariable Long id, @RequestBody ProdutoDto produtoDto){
        return ResponseEntity.ok(produtoPort.updateProdutoById(id, produtoDto));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Produto> deleteProdutoById(@PathVariable Long id){
        return ResponseEntity.ok(produtoPort.deleteProdutoById(id));
    }

}
