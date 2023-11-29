package com.TCC.gerenciamentoEstoque.domain.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FornecedorDto {
    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String telefone;
    private String endereço;
}
