package com.TCC.gerenciamentoEstoque.domain.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDto {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
}
