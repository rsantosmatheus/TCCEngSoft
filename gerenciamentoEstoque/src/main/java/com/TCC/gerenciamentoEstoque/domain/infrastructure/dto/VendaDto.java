package com.TCC.gerenciamentoEstoque.domain.infrastructure.dto;

import com.TCC.gerenciamentoEstoque.domain.model.Cliente;
import com.TCC.gerenciamentoEstoque.domain.model.Funcionario;
import com.TCC.gerenciamentoEstoque.domain.model.Produto;
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
    private Funcionario funcionario;
    private Cliente cliente;

}
