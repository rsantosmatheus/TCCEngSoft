package com.TCC.gerenciamentoEstoque.ports.input;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.VendaDto;
import com.TCC.gerenciamentoEstoque.domain.model.Venda;

import java.util.Date;
import java.util.List;

public interface VendaPort {

    List<VendaDto> getAllVendas();

    List<VendaDto> getVendasByDates(Date startDate, Date endDate);

    List<VendaDto> getVendasByCliente(Long idCleinte, Date startDate, Date endDate);

    VendaDto getVendasById(Long id);

    Venda createVenda(VendaDto vendaDto);

    Venda updateVenda(Long id, VendaDto vendaDto);

    Venda deleteVenda(Long id);
}
