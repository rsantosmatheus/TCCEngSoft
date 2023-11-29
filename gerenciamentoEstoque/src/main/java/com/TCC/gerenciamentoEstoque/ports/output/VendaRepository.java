package com.TCC.gerenciamentoEstoque.ports.output;

import com.TCC.gerenciamentoEstoque.domain.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
