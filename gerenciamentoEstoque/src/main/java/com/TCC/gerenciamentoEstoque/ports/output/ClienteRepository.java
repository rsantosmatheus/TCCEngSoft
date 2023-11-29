package com.TCC.gerenciamentoEstoque.ports.output;

import com.TCC.gerenciamentoEstoque.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(nativeQuery= true, value="SELECT * FROM cliente WHERE cnpjCpf = ? LIMIT 1")
    Cliente findClienteByCnpjCpf(String cnpjCpf);


}
