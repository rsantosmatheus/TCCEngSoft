package com.TCC.gerenciamentoEstoque.ports.output;

import com.TCC.gerenciamentoEstoque.domain.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM venda " +
            "WHERE data BETWEEN :startDate AND :endDate")
    List<Venda> getVendasByDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(nativeQuery = true, value = "SELECT * FROM venda " +
            "WHERE cliente_id = :idCliente " +
            "AND data BETWEEN :startDate AND :endDate")
    List<Venda> getVendasByClienteAndDates(@Param("idCliente") Long idCliente,
                                           @Param("startDate") Date startDate,
                                           @Param("endDate") Date endDate);


}
