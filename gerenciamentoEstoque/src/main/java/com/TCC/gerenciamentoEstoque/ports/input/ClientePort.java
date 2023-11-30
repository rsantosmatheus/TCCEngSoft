package com.TCC.gerenciamentoEstoque.ports.input;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ClienteDto;
import com.TCC.gerenciamentoEstoque.domain.model.Cliente;

import java.util.List;

public interface ClientePort {

    List<ClienteDto> getAllClientes();

    ClienteDto getClienteByCnpjCpf(String cnpjCpf);

    Cliente createCliente(ClienteDto clienteDto);

    Cliente updateClienteById(Long id, ClienteDto clienteDto);

    Cliente deleteClienteById(Long id);
}
