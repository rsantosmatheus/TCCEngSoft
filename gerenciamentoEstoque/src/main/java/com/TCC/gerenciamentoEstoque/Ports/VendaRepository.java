package com.TCC.gerenciamentoEstoque.Ports;

import com.TCC.gerenciamentoEstoque.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
