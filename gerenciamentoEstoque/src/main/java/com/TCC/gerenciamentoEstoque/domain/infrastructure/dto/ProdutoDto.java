package com.TCC.gerenciamentoEstoque.domain.infrastructure.dto;

import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;
import com.TCC.gerenciamentoEstoque.domain.model.Venda;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {
    private Long id;
    private String nome;
    private int codInterno;
    private FornecedorDto fornecedor;
    private double valorCompra;
    private double valorVenda;
    private int quantidadeMinima;
    private Venda venda;
}
