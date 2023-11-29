package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ClienteDto;
import com.TCC.gerenciamentoEstoque.domain.model.Cliente;

public interface ClienteMapper {

    Cliente clienteMapper(ClienteDto clienteDto);
    ClienteDto clienteDtoMapper(Cliente cliente);

}
