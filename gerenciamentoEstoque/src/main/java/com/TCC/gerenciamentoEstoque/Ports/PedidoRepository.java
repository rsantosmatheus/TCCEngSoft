package com.TCC.gerenciamentoEstoque.Ports;

import com.TCC.gerenciamentoEstoque.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
