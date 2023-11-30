package com.TCC.gerenciamentoEstoque.ports.output;

import com.TCC.gerenciamentoEstoque.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM produto WHERE nome LIKE %?1%")
    List<Produto> findProdutoByNomeLike(String nome);

    @Query(nativeQuery = true, value = "SELECT * FROM produto WHERE codInterno =?")
    List<Produto> findProdutoByCodInterno(int codInterno);
}
