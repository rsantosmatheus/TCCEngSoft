package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.VendaDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ClienteMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FuncionarioMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ProdutoMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.VendaMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Estoque;
import com.TCC.gerenciamentoEstoque.domain.model.Venda;
import com.TCC.gerenciamentoEstoque.ports.input.VendaPort;
import com.TCC.gerenciamentoEstoque.ports.output.EstoqueRepository;
import com.TCC.gerenciamentoEstoque.ports.output.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VendaUseCase implements VendaPort {

    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    VendaMapper vendaMapper;

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    FuncionarioMapper funcionarioMapper;

    @Autowired
    ClienteMapper clienteMapper;

    @Autowired
    ProdutoMapper produtoMapper;

    @Override
    public List<VendaDto> getAllVendas() throws CustomException{
        List<VendaDto> vendaDtos = new ArrayList<>();

        vendaRepository.findAll().forEach(venda -> vendaDtos.add(vendaMapper.vendaDtoMapper(venda)));
        if(vendaDtos.size()<1){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }

        return vendaDtos;
    }

    @Override
    public List<VendaDto> getVendasByDates(Date startDate, Date endDate) throws CustomException{
        List<VendaDto> vendaDtos = new ArrayList<>();

        vendaRepository.getVendasByDates(startDate,endDate).forEach(venda -> vendaDtos.add(vendaMapper.vendaDtoMapper(venda)));
        if(vendaDtos.size()<1){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }

        return vendaDtos;
    }

    @Override
    public List<VendaDto> getVendasByCliente(Long idCleinte, Date startDate, Date endDate) throws CustomException{
        List<VendaDto> vendaDtos = new ArrayList<>();

        vendaRepository.getVendasByClienteAndDates(idCleinte, startDate,endDate).forEach(venda -> vendaDtos.add(vendaMapper.vendaDtoMapper(venda)));
        if(vendaDtos.size()<1){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }

        return vendaDtos;
    }

    @Override
    public VendaDto getVendasById(Long id) throws CustomException{
        try {
            VendaDto vendaDto = vendaMapper.vendaDtoMapper(vendaRepository.findById(id).orElseThrow());

            return vendaDto;
        }catch (CustomException e){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
    }

    @Override
    public Venda createVenda(VendaDto vendaDto){
        Venda venda = vendaMapper.vendaMapper(vendaDto);
        Estoque estoque = estoqueRepository.findEstoqueByCodInterno(vendaDto.getProduto().getCodInterno());

        if (estoque.getProduto() == null){
            estoque.setQuantidade(venda.getQuantidade());
            estoque.setProduto(venda.getProduto());
        }else{
            estoque.setQuantidade(estoque.getQuantidade() + venda.getQuantidade());
        }

        vendaRepository.save(venda);

        return venda;
    }

    @Override
    public Venda updateVenda(Long id, VendaDto vendaDto) throws CustomException{
        try {
            Venda venda = vendaRepository.findById(id).orElseThrow();
            if (venda.getQuantidade() != vendaDto.getQuantidade()) {
                Estoque estoque = estoqueRepository.findEstoqueByCodInterno(vendaDto.getProduto().getCodInterno());
                estoque.setQuantidade(estoque.getQuantidade() + (vendaDto.getQuantidade() - venda.getQuantidade()));
                estoqueRepository.save(estoque);
            }

            venda.setProduto(produtoMapper.produtoMapper(vendaDto.getProduto()));
            venda.setQuantidade(vendaDto.getQuantidade());
            venda.setData(vendaDto.getData());
            venda.setCliente(clienteMapper.clienteMapper(vendaDto.getCliente()));
            venda.setFuncionario(funcionarioMapper.funcionarioMapper(vendaDto.getFuncionario()));

            vendaRepository.save(venda);

            return venda;
        }catch (CustomException e){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
    }

    @Override
    public Venda deleteVenda(Long id) throws CustomException{
        try {
            Venda venda = vendaRepository.findById(id).orElseThrow();
            vendaRepository.deleteById(id);

            return venda;
        }catch (CustomException e){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
    }
}
