package com.TCC.gerenciamentoEstoque.Ports;

import com.TCC.gerenciamentoEstoque.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
