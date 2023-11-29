package com.TCC.gerenciamentoEstoque.domain.infrastructure.dto;

import com.TCC.gerenciamentoEstoque.domain.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstoqueDto {

    private Long id;
    private ProdutoDto produto;
    private int quantidade;
}
