package com.TCC.gerenciamentoEstoque.domain.infrastructure.dto;

import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;
import com.TCC.gerenciamentoEstoque.domain.model.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PedidoDto {
    private Long id;
    private int produto;
    private int quantidade;
    private Date data;
    private Funcionario funcionario;
    private Fornecedor fornecedor;
}
