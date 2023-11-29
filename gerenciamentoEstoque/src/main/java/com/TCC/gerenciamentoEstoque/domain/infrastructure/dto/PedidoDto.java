package com.TCC.gerenciamentoEstoque.domain.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PedidoDto {
    private Long id;
    private ProdutoDto produto;
    private int quantidade;
    private Date data;
    private FuncionarioDto funcionario;
    private FornecedorDto fornecedor;
}
