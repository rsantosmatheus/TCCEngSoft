package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ClienteDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ClienteMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Cliente;
import com.TCC.gerenciamentoEstoque.ports.input.ClientePort;
import com.TCC.gerenciamentoEstoque.ports.output.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteUseCase implements ClientePort {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteMapper clienteMapper;


    @Override
    public List<ClienteDto> getAllClientes() {

        List<ClienteDto>clienteDtos = new ArrayList<>();
        clienteRepository.findAll().forEach(cliente -> clienteDtos.add(clienteMapper.clienteDtoMapper(cliente)));
        return clienteDtos;
    }

    @Override
    public ClienteDto getClienteByCnpjCpf(String cnpjCpf) {
        Cliente cliente = clienteRepository.findClienteByCnpjCpf(cnpjCpf);

        return clienteMapper.clienteDtoMapper(cliente);
    }

    @Override
    public Cliente createCliente(ClienteDto clienteDto) {

        Cliente cliente = clienteMapper.clienteMapper(clienteDto);
        clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public Optional<Cliente> updateClienteById(Long id, ClienteDto clienteDto) {

        Optional<Cliente> cliente = clienteRepository.findById(id);
        clienteRepository.save(clienteMapper.clienteMapper(clienteDto));
        return cliente;
    }

    @Override
    public Optional<Cliente> deleteClienteById(Long id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);
        clienteRepository.deleteById(id);
        return cliente;
    }
}
