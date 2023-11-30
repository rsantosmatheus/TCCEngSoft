package com.TCC.gerenciamentoEstoque.ports.output;

import com.TCC.gerenciamentoEstoque.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(nativeQuery= true, value="SELECT * FROM pedido WHERE produto_id = ?")
    List<Pedido> findPedidoByProdudoId(Long idProduto);

    @Query(nativeQuery= true, value="SELECT * FROM pedido WHERE funcionario_id = ?")
    List<Pedido> findPedidoByFuncionarioId(Long idFuncionario);

    @Query(nativeQuery= true, value="SELECT * FROM pedido WHERE fornecedor_id = ?")
    List<Pedido> findPedidoByFornecedorId(Long idFornecedor);
}
