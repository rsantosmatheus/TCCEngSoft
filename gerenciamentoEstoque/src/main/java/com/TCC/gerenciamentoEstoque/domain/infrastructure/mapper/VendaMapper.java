package com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.VendaDto;
import com.TCC.gerenciamentoEstoque.domain.model.Venda;

public interface VendaMapper {

    Venda vendaMapper (VendaDto vendaDto);

    VendaDto vendaDtoMapper (Venda venda);
}
