package com.TCC.gerenciamentoEstoque.ports.input;

import com.TCC.gerenciamentoEstoque.domain.model.Cliente;

import java.util.List;

public interface ClientePort {

    List<Cliente> getAllClientes();

    List<Cliente> getClienteByCnpjCpf(String cnpjCpf);

    Cliente createCliente(Cliente cliente);
}
