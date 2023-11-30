package com.TCC.gerenciamentoEstoque.ports.output;

import com.TCC.gerenciamentoEstoque.domain.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    @Query(nativeQuery = true, value = "SELECT e.id, e.produto_id, e.quantidade " +
            "FROM Estoque e " +
            "JOIN Produto p ON p.id = e.produto_id " +
            "WHERE p.codInterno = ?1 " +
            "ORDER BY p.codInterno LIMIT 1")
    Estoque findEstoqueByCodInterno(int codInterno);

    @Query(nativeQuery = true, value = "SELECT SUM(p.valorCompra) " +
            "FROM Estoque e " +
            "JOIN Produto p ON p.id = e.produto_id")
    BigDecimal somarValorCompraProdutosEmEstoque();

    @Query(nativeQuery = true, value = "SELECT SUM(p.valorVenda) " +
            "FROM Estoque e " +
            "JOIN Produto p ON p.id = e.produto_id")
    BigDecimal somarValorVendaProdutosEmEstoque();
}
