package com.TCC.gerenciamentoEstoque.adapter.controller;

import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.VendaDto;
import com.TCC.gerenciamentoEstoque.domain.model.Venda;
import com.TCC.gerenciamentoEstoque.ports.input.VendaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    VendaPort vendaPort;

    @GetMapping
    public ResponseEntity<List<VendaDto>> getAllVendas(){
        return ResponseEntity.ok(vendaPort.getAllVendas());
    }

    @GetMapping("/{startDate}/{endDate}")
    public ResponseEntity<List<VendaDto>>getVendasByDatas( @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                           @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return ResponseEntity.ok(vendaPort.getVendasByDates(startDate,endDate));
    }

    @GetMapping("/{idCliente}/{startDate}/{endDate}")
    public ResponseEntity<List<VendaDto>> getVendasByClienteAndData(@PathVariable Long idCleinte,
                                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return ResponseEntity.ok(vendaPort.getVendasByCliente(idCleinte, startDate, endDate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDto>getVendasById(@PathVariable Long id){
        return ResponseEntity.ok(vendaPort.getVendasById(id));
    }

    @PostMapping
    public ResponseEntity<Venda> createVenda(@RequestBody VendaDto vendaDto){
        return ResponseEntity.ok(vendaPort.createVenda(vendaDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> updateVenda(@PathVariable Long id, @RequestBody VendaDto vendaDto){
        return ResponseEntity.ok(vendaPort.updateVenda(id,vendaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Venda>deleteVenda(@PathVariable Long id){
        return ResponseEntity.ok(vendaPort.deleteVenda(id));
    }
}
