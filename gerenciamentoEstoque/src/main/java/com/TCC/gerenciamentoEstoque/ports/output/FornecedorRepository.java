package com.TCC.gerenciamentoEstoque.ports.output;

import com.TCC.gerenciamentoEstoque.domain.model.Fornecedor;
import com.TCC.gerenciamentoEstoque.ports.input.FornecedorPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM fornecedor WHERE cnpj = ? LIMIT 1")
    Fornecedor findFornecedorByCnpj(String cnpj);
}
