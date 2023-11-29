package com.TCC.gerenciamentoEstoque.adapter.input.controller;

import com.TCC.gerenciamentoEstoque.domain.model.Cliente;
import com.TCC.gerenciamentoEstoque.ports.input.ClientePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClientePort clientePort;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok(clientePort.getAllClientes());
    }

    @GetMapping("/{cnpjOuCnpj}")
    public ResponseEntity<List<Cliente>> getClienteByCnpj(@PathVariable String cnpjOuCnpj){
        return ResponseEntity.ok(clientePort.getClienteByCnpjCpf(cnpjOuCnpj));
    }

    @PostMapping
    public ResponseEntity<Cliente> postCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clientePort.createCliente(cliente));
    }
}
