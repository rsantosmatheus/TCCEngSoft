package com.TCC.gerenciamentoEstoque.ports.output;

import com.TCC.gerenciamentoEstoque.domain.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
