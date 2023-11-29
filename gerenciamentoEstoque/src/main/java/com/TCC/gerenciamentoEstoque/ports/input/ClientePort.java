package com.TCC.gerenciamentoEstoque.ports.input;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ClienteDto;
import com.TCC.gerenciamentoEstoque.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClientePort {

    List<ClienteDto> getAllClientes();

    ClienteDto getClienteByCnpjCpf(String cnpjCpf);

    Cliente createCliente(ClienteDto clienteDto);

    Optional<Cliente> updateClienteById(Long id, ClienteDto clienteDto);


    Optional<Cliente> deleteClienteById(Long id);
}
