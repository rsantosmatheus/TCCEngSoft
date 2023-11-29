package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.PedidoDto;
import com.TCC.gerenciamentoEstoque.domain.model.Pedido;

public interface PedidoMapper {

    Pedido pedidoMapper (PedidoDto pedidoDto);

    PedidoDto pedidoDtoMapper (Pedido pedido);
}
