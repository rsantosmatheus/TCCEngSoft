package com.TCC.gerenciamentoEstoque.domain.infrastructure.dto;

import com.TCC.gerenciamentoEstoque.domain.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstoqueDto {

    private Long id;
    private Produto produto;
    private int quantidade;
}
