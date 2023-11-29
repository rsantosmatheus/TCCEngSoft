package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.model.Cliente;
import com.TCC.gerenciamentoEstoque.ports.input.ClientePort;
import com.TCC.gerenciamentoEstoque.ports.output.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteUseCase implements ClientePort {

    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> getClienteByCnpjCpf(String cnpjCpf) {
        return clienteRepository.findClienteByCnpjCpf(cnpjCpf);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }
}
