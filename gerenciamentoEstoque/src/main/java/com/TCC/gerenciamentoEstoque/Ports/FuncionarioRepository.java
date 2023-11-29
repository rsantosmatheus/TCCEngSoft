package com.TCC.gerenciamentoEstoque.Ports;

import com.TCC.gerenciamentoEstoque.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
