package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ClienteDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ClienteMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Cliente;
import com.TCC.gerenciamentoEstoque.ports.input.ClientePort;
import com.TCC.gerenciamentoEstoque.ports.output.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteUseCase implements ClientePort {

    private static String REGEX = "[^0-9]";

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
            if(cliente.getCnpjOuCpf().isEmpty()|| cliente.getCnpjOuCpf().isBlank()){
                throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
            }
            return clienteMapper.clienteDtoMapper(cliente);
    }

    @Override
    public Cliente createCliente(ClienteDto clienteDto) throws CustomException {

        clienteDto.setCnpjOuCpf(clienteDto.getCnpjOuCpf().replaceAll(REGEX,""));

        Cliente cliente = clienteMapper.clienteMapper(clienteDto);
        Optional<Cliente> clienteOptional = Optional.ofNullable(clienteRepository
                .findClienteByCnpjCpf(clienteDto.getCnpjOuCpf()));

        if (clienteOptional.isPresent()){
            throw new CustomException("Já cadastrado",  ResponseEntity.status(400).body("Já Existe"));
        };

        clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public Cliente updateClienteById(Long id, ClienteDto clienteDto) throws CustomException{

        try {
            Cliente cliente = clienteRepository.findById(id).orElseThrow();

            cliente.setCnpjOuCpf(clienteDto.getCnpjOuCpf());
            cliente.setTelefone(clienteDto.getTelefone());
            cliente.setEndereço(clienteDto.getEndereço());
            cliente.setRazaoSocial(clienteDto.getRazaoSocial());
            clienteRepository.save(cliente);

            return cliente;
        } catch (CustomException e){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
    }

    @Override
    public Cliente deleteClienteById(Long id) throws CustomException{
        try {
            Cliente cliente = clienteRepository.findById(id).orElseThrow();
            clienteRepository.deleteById(id);
            return cliente;
        }  catch (CustomException e){
        throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
    }
}
