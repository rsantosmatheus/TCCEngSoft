package com.TCC.gerenciamentoEstoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.TCC.gerenciamentoEstoque")
public class GerenciamentoEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoEstoqueApplication.class, args);
	}

}
