package com.TCC.gerenciamentoEstoque.Ports;

import com.TCC.gerenciamentoEstoque.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
