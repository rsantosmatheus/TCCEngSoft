package com.TCC.gerenciamentoEstoque.domain.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {

    private Long id;
    private String razaoSocial;
    private String cnpjOuCpf;
    private String telefone;
    private String endereço;
}
