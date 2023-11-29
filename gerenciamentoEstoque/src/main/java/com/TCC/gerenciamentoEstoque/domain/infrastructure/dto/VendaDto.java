package com.TCC.gerenciamentoEstoque.domain.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VendaDto {

    private Long id;
    private List<ProdutoDto> produtos;
    private Date data;
    private FuncionarioDto funcionario;
    private ClienteDto cliente;

}
