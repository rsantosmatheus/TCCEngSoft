package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.impl;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ClienteDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ClienteMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteMapperImp implements ClienteMapper {
    @Override
    public Cliente clienteMapper(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();

        cliente.setId(clienteDto.getId());
        cliente.setCnpjOuCpf(clienteDto.getCnpjOuCpf());
        cliente.setEndereço(clienteDto.getEndereço());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setRazaoSocial(clienteDto.getRazaoSocial());
        return cliente;
    }

    @Override
    public ClienteDto clienteDtoMapper(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setId(cliente.getId());
        clienteDto.setCnpjOuCpf(cliente.getCnpjOuCpf());
        clienteDto.setEndereço(cliente.getEndereço());
        clienteDto.setTelefone(cliente.getTelefone());
        clienteDto.setRazaoSocial(cliente.getRazaoSocial());

        return clienteDto;
    }
}
