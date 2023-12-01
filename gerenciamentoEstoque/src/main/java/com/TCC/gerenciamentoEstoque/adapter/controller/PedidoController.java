package com.TCC.gerenciamentoEstoque.adapter.controller;


import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.PedidoDto;
import com.TCC.gerenciamentoEstoque.domain.model.Pedido;
import com.TCC.gerenciamentoEstoque.ports.input.PedidoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {

    @Autowired
    PedidoPort pedidoPort;

    @GetMapping
    public ResponseEntity<List<PedidoDto>> getAllPedidos(){
        return ResponseEntity.ok(pedidoPort.getAllPedidos());
    }

    @GetMapping("/produto/{idProduto}")
    public ResponseEntity<List<PedidoDto>> getAllPedidosByIdProduto(@PathVariable Long idProduto){
        return ResponseEntity.ok(pedidoPort.getAllPedidosByIdProduto(idProduto));
    }

    @GetMapping("/fornecedor/{idFornecedor}")
    public ResponseEntity<List<PedidoDto>> getAllPedidosByIdFornecedor(@PathVariable Long idFornecedor){
        return ResponseEntity.ok(pedidoPort.getAllPedidosByIdFornecedor(idFornecedor));
    }

    @GetMapping("/funcionario/{idFuncionario}")
    public ResponseEntity<List<PedidoDto>> getAllPedidosByIdFuncionario(@PathVariable Long idFuncionario){
        return ResponseEntity.ok(pedidoPort.getAllPedidosByIdFuncionario(idFuncionario));
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<PedidoDto> getPedidoById(@PathVariable Long id){
        return ResponseEntity.ok(pedidoPort.getPedidoById(id));
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody PedidoDto pedidoDto){
        return ResponseEntity.ok((pedidoPort.createPedido(pedidoDto)));
    }

    @PutMapping("/{idPedido}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody PedidoDto pedidoDto){
        return ResponseEntity.ok(pedidoPort.updatePedido(id, pedidoDto));
    }

    @DeleteMapping("/{idPedido}")
    public ResponseEntity<Pedido> deletePedidoById(@PathVariable Long id){
        return ResponseEntity.ok(pedidoPort.deletePedidoById(id));
    }
}
