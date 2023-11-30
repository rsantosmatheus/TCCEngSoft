package com.TCC.gerenciamentoEstoque.ports.input;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.PedidoDto;
import com.TCC.gerenciamentoEstoque.domain.model.Pedido;

import java.util.List;

public interface PedidoPort {

    List<PedidoDto> getAllPedidos();

    List<PedidoDto> getAllPedidosByIdProduto(Long idProduto);

    List<PedidoDto> getAllPedidosByIdFornecedor(Long idFornecedor);

    List<PedidoDto> getAllPedidosByIdFuncionario(Long idFuncionario);

    PedidoDto getPedidoById(Long id);

    Pedido createPedido(PedidoDto pedidoDto);

    Pedido updatePedido(Long id, PedidoDto PedidoDto);

    Pedido deletePedidoById(Long id);
}
