-- src/main/resources/data.sql

INSERT INTO fornecedor (razao_social, cnpj, telefone, endereco) VALUES
 ('Fornecedor Alpha', '12345678901234', '123-456-7890', 'Rua das Flores, 123'),
 ('Fornecedor Beta', '56789012345678', '987-654-3210', 'Rua dos Comerciantes, 456'),
 ('Fornecedor Gama', '98765432101234', '555-123-4567', 'Avenida dos Artistas, 789'),
 ('Fornecedor Delta', '11223344556677', '999-888-7776', 'Rua das Indústrias, 321'),
 ('Fornecedor Épsilon', '99887766554433', '111-222-3334', 'Avenida das Tecnologias, 654'),
 ('Fornecedor Zeta', '44556677889900', '333-444-5558', 'Rua dos Viajantes, 987'),
 ('Fornecedor Eta', '22334455667788', '777-888-9990', 'Avenida dos Estudantes, 111'),
 ('Fornecedor Teta', '33445566778899', '444-555-6662', 'Rua das Esquinas, 876'),
 ('Fornecedor Ípsilon', '66778899001122', '666-777-8884', 'Avenida dos Parques, 222'),
 ('Fornecedor Kappa', '99001122334455', '222-333-4446', 'Rua dos Ares, 765'),
 ('Fornecedor Lambda', '11223344556699', '888-999-0008', 'Avenida dos Lagos, 333'),
 ('Fornecedor Mu', '44556677889911', '555-666-7770', 'Rua das Montanhas, 654'),
 ('Fornecedor Nu', '66778899001133', '777-888-9992', 'Avenida dos Bosques, 111'),
 ('Fornecedor Xi', '99001122334444', '111-222-3334', 'Rua dos Mares, 876'),
 ('Fornecedor Ômicron', '22334455667755', '444-555-6666', 'Avenida das Colinas, 222');


INSERT INTO cliente (razao_social, cnpj_ou_cpf, telefone, endereco) VALUES
  -- Empresas
  ('Empresa Silva Ltda', '12345678000101', '123-456-7890', 'Rua dos Empresários, 123'),
  ('Comércio Oliveira', '56789012000199', '987-654-3210', 'Avenida das Indústrias, 456'),
  ('Loja Pereira & Cia', '98765432000155', '555-123-4567', 'Rua Comercial, 789'),
  ('Restaurante Costa do Mar', '11223344000166', '999-888-7776', 'Avenida Beira Mar, 321'),
  ('Supermercado Santos', '99887766000122', '111-222-3334', 'Rua das Frutas, 654'),
  ('Farmácia Mendes', '44556677000133', '333-444-5558', 'Avenida Saúde, 987'),
  ('Boutique Lima', '22334455000144', '777-888-9990', 'Rua da Moda, 111'),
  ('Papelaria Souza', '33445566000188', '444-555-6662', 'Avenida dos Livros, 876'),
  ('José da Silva', '12345678901', '123-456-7890', 'Rua dos Trabalhadores, 123'),
  ('Maria Oliveira', '56789012345', '987-654-3210', 'Avenida das Famílias, 456'),
  ('João Pereira', '98765432109', '555-123-4567', 'Rua dos Amigos, 789'),
  ('Ana Costa', '11223344556', '999-888-7776', 'Avenida da Alegria, 321'),
  ('Luiz Santos', '99887766543', '111-222-3334', 'Rua da Paz, 654'),
  ('Fernanda Mendes', '44556677890', '333-444-5558', 'Avenida do Amor, 987'),
  ('Pedro Lima', '22334455678', '777-888-9990', 'Rua da Harmonia, 111');

  INSERT INTO funcionario (nome, cpf, telefone, endereco) VALUES
    ('Ana Silva', '123.456.789-01', '123-456-7890', 'Rua dos Trabalhadores, 123'),
    ('Carlos Oliveira', '987.654.321-09', '555-123-4567', 'Avenida das Famílias, 456'),
    ('Roberto Pereira', '112.233.445-56', '999-888-7776', 'Rua dos Amigos, 789'),
    ('Mariana Costa', '998.877.665-43', '111-222-3334', 'Avenida da Alegria, 321'),
    ('Lucas Santos', '445.566.778-90', '333-444-5558', 'Rua da Paz, 654'),
    ('Juliana Mendes', '223.344.556-78', '777-888-9990', 'Avenida do Amor, 987'),
    ('Fernando Lima', '334.455.660-01', '444-555-6662', 'Rua da Harmonia, 111'),
    ('Camila Oliveira', '667.788.990-11', '666-777-8884', 'Avenida da Felicidade, 222'),
    ('Gustavo Santos', '990.011.223-33', '222-333-4446', 'Rua da Prosperidade, 765'),
    ('Isabela Mendes', '112.233.445-66', '888-999-0008', 'Avenida das Conquistas, 333');
    ('Anderson Silva', '876.543.210-98', '987-654-3210', 'Avenida das Oportunidades, 123'),
    ('Carolina Oliveira', '654.321.098-76', '555-123-4567', 'Rua das Carreiras, 456'),
    ('Rafael Pereira', '543.210.987-65', '999-888-7776', 'Avenida dos Talentos, 789'),
    ('Luiza Costa', '098.765.432-10', '111-222-3334', 'Rua dos Conhecimentos, 321'),
    ('Pedro Santos', '345.678.901-23', '333-444-5558', 'Avenida das Experiências, 654');

    -- src/main/resources/data.sql

    INSERT INTO produto (nome, cod_interno, fornecedor_id, valor_compra, valor_venda, quantidade_minima) VALUES
      ('Arroz Integral', 1001, 1, 5.99, 9.99, 50),
      ('Notebook HP', 2002, 2, 2499.99, 2999.99, 10),
      ('Sapato Social Masculino', 3003, 3, 89.99, 129.99, 20),
      ('Panela de Pressão Inox', 4004, 4, 79.99, 119.99, 15),
      ('Smartphone Samsung Galaxy', 5005, 5, 1299.99, 1599.99, 30),
      ('Máquina de Café Expresso', 6006, 6, 299.99, 399.99, 5),
      ('Fogão 4 Bocas', 7007, 7, 499.99, 599.99, 8),
      ('Conjunto de Talheres Inox', 8008, 8, 29.99, 49.99, 40),
      ('Bicicleta Mountain Bike', 9009, 9, 899.99, 1199.99, 12),
      ('Mochila Escolar', 1010, 10, 39.99, 59.99, 25),
      ('Câmera Digital Canon', 1111, 11, 499.99, 699.99, 7),
      ('Tapete Decorativo', 1212, 12, 19.99, 29.99, 50),
      ('Liquidificador Philips', 1313, 13, 69.99, 99.99, 18),
      ('Livro "O Hobbit"', 1414, 14, 29.99, 39.99, 30),
      ('Pneu de Carro', 1515, 15, 89.99, 129.99, 15),
      ('Headphone Bluetooth', 1616, 16, 59.99, 79.99, 22),
      ('Kit de Ferramentas', 1717, 17, 129.99, 159.99, 10),
      ('Cadeira de Escritório', 1818, 18, 149.99, 199.99, 12),
      ('Impressora Multifuncional', 1919, 19, 129.99, 179.99, 8),
      ('Relógio de Pulso', 2020, 20, 79.99, 99.99, 15);

-- src/main/resources/data.sql

INSERT INTO pedido (produto_id, quantidade, data, funcionario_id, fornecedor_id) VALUES
  (1, 5, '2023-01-15', 1, 1),
  (2, 1, '2023-01-16', 2, 2),
  (3, 3, '2023-01-17', 3, 3),
  (4, 2, '2023-01-18', 4, 4),
  (5, 4, '2023-01-19', 5, 5),
  (6, 1, '2023-01-20', 6, 6),
  (7, 2, '2023-01-21', 7, 7),
  (8, 10, '2023-01-22', 8, 8),
  (9, 1, '2023-01-23', 9, 9),
  (10, 3, '2023-01-24', 10, 10),
  (11, 2, '2023-01-25', 11, 11),
  (12, 1, '2023-01-26', 12, 12),
  (13, 5, '2023-01-27', 13, 13),
  (14, 2, '2023-01-28', 14, 14),
  (15, 3, '2023-01-29', 15, 15),
  (16, 1, '2023-01-30', 16, 16),
  (17, 4, '2023-01-31', 17, 17),
  (18, 2, '2023-02-01', 18, 18),
  (19, 1, '2023-02-02', 19, 19),
  (20, 3, '2023-02-03', 20, 20);

-- src/main/resources/data.sql

INSERT INTO venda (produto_id, data, quantidade, funcionario_id, cliente_id) VALUES
  (1, '2020-05-15', 5, 1, 1),
  (2, '2021-02-16', 1, 2, 2),
  (3, '2021-06-17', 3, 3, 3),
  (4, '2022-01-18', 2, 4, 4),
  (5, '2022-09-19', 4, 5, 5),
  (6, '2020-11-20', 1, 6, 6),
  (7, '2021-07-21', 2, 7, 7),
  (8, '2022-03-22', 10, 8, 8),
  (9, '2021-12-23', 1, 9, 9),
  (10, '2022-04-24', 3, 10, 10),
  (11, '2022-08-25', 2, 11, 11),
  (12, '2020-12-26', 1, 12, 12),
  (13, '2021-10-27', 5, 13, 13),
  (14, '2022-02-28', 2, 14, 14),
  (15, '2021-09-29', 3, 15, 15),
  (16, '2020-07-30', 1, 16, 16),
  (17, '2022-11-01', 4, 17, 17),
  (18, '2022-05-02', 2, 18, 18),
  (19, '2021-03-03', 1, 19, 19),
  (20, '2020-08-05', 3, 20, 20);

INSERT INTO estoque (produto_id, quantidade) VALUES
  (1, 5),
  (2, 1),
  (3, 3),
  (4, 2),
  (5, 4),
  (6, 1),
  (7, 2),
  (8, 10),
  (9, 1),
  (10, 3),
  (11, 2),
  (12, 1),
  (13, 5),
  (14, 2),
  (15, 3),
  (16, 1),
  (17, 4),
  (18, 2),
  (19, 1),
  (20, 3);