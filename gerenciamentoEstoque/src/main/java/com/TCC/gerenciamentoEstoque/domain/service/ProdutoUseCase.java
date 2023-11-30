package com.TCC.gerenciamentoEstoque.domain.service;

import com.TCC.gerenciamentoEstoque.domain.exception.CustomException;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.dto.ProdutoDto;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.FornecedorMapper;
import com.TCC.gerenciamentoEstoque.domain.infrastructure.mapper.ProdutoMapper;
import com.TCC.gerenciamentoEstoque.domain.model.Produto;
import com.TCC.gerenciamentoEstoque.ports.input.ProdutoPort;
import com.TCC.gerenciamentoEstoque.ports.output.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoUseCase implements ProdutoPort {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ProdutoMapper produtoMapper;

    @Autowired
    FornecedorMapper fornecedorMapper;

    @Override
    public List<ProdutoDto> getAllProdutos() throws CustomException{

        List<ProdutoDto> produtoDtos = new ArrayList<>();
        produtoRepository.findAll().forEach(produto -> produtoDtos.add(produtoMapper.produtoDtoMapper(produto)));
        if(produtoDtos.size()<1){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
        return produtoDtos;
    }

    @Override
    public ProdutoDto getProdutoById(Long id) throws CustomException {
        Produto produto = produtoRepository.findById(id).orElseThrow();

        return produtoMapper.produtoDtoMapper(produto);
    }

    @Override
    public List<ProdutoDto> getProdutoByCodigoInterno(int codInternoProduto) {
        return null;
    }

    @Override
    public List<ProdutoDto> getProdutoByNomeParecido(String nameLike) throws CustomException{
        List<Produto> produtos = produtoRepository.findProdutoByNomeLike(nameLike);
        if (produtos.size()<1){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
        List<ProdutoDto> produtoDtos = new ArrayList<>();
        produtos.forEach(produto -> produtoDtos.add(produtoMapper.produtoDtoMapper(produto)));
        return produtoDtos;
    }

    @Override
    public Produto createProduto(ProdutoDto produtoDto) throws CustomException{
        Produto produto = produtoMapper.produtoMapper(produtoDto);
        produtoRepository.save(produto);
        return produto;
    }

    @Override
    public Produto updateProdutoById(Long id, ProdutoDto produtoDto) throws CustomException{
        try {
            Produto produto = produtoRepository.findById(id).orElseThrow();

            produto.setFornecedor(fornecedorMapper.fornecedorMapper(produtoDto.getFornecedor()));
            produto.setNome(produtoDto.getNome());
            produto.setCodInterno(produtoDto.getCodInterno());
            produto.setQuantidadeMinima(produtoDto.getQuantidadeMinima());
            produto.setValorVenda(produtoDto.getValorVenda());
            produto.setValorCompra(produtoDto.getValorCompra());

            return produto;
        }catch (CustomException e){
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
    }

    @Override
    public Produto deleteProdutoById(Long id) throws CustomException {
        try {
            Produto produto = produtoRepository.findById(id).orElseThrow();
            produtoRepository.deleteById(id);
            return produto;
        } catch (CustomException e) {
            throw new CustomException("Não encontrado", ResponseEntity.status(400).body("Não Encontrado"));
        }
    }
}
