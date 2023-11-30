package com.TCC.gerenciamentoEstoque.domain.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VendaDto {

    private Long id;
    private ProdutoDto produto;
    private Date data;
    private int quantidade;
    private FuncionarioDto funcionario;
    private ClienteDto cliente;

}
