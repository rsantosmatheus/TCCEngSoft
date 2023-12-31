package com.TCC.gerenciamentoEstoque.adapter.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ClienteDto;
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
    public ResponseEntity<List<ClienteDto>> getAllClientes(){
        return ResponseEntity.ok(clientePort.getAllClientes());
    }

    @GetMapping("/{cnpjOuCnpj}")
    public ResponseEntity<ClienteDto> getClienteByCnpj(@PathVariable String cnpjOuCnpj){
        return ResponseEntity.ok(clientePort.getClienteByCnpjCpf(cnpjOuCnpj));
    }

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody ClienteDto clienteDto){
        return ResponseEntity.ok(clientePort.createCliente(clienteDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClienteById(@PathVariable Long id, @RequestBody ClienteDto clienteDto){
        return ResponseEntity.ok(clientePort.updateClienteById(id, clienteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteClienteById(@PathVariable Long id){
        return ResponseEntity.ok(clientePort.deleteClienteById(id));
    }
}
