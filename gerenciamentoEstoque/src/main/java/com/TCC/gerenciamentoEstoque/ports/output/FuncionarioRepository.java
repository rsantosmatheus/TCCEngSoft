package com.TCC.gerenciamentoEstoque.ports.output;

import com.TCC.gerenciamentoEstoque.domain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    @Query(nativeQuery= true, value="SELECT * FROM funcionario WHERE cpf = ? LIMIT 1")
    Funcionario findFuncionarioByCpf(String cpf);

}
