package com.TCC.gerenciamentoEstoque.ports.input;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ProdutoDto;
import com.TCC.gerenciamentoEstoque.domain.model.Produto;

import java.util.List;

public interface ProdutoPort {
    List<ProdutoDto> getAllProdutos();

    ProdutoDto getProdutoById(Long id);

    List<ProdutoDto> getProdutoByCodigoInterno(int codInternoProduto);

    List<ProdutoDto> getProdutoByNomeParecido(String nameLike);

    Produto createProduto(ProdutoDto produtoDto);

    Produto updateProdutoById(Long id, ProdutoDto produtoDto);

    Produto deleteProdutoById(Long id);
}
