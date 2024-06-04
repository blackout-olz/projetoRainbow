/**
 * Author:  xuniro
 * Created: 16 de mai. de 2024
 */

-- tabelas principais

-- cria tabela tb_clientes
CREATE TABLE tb_clientes(
id int NOT NULL auto_increment,
nome varchar(255) NOT NULL,
cpf char(11) NOT NULL,
email varchar(100) DEFAULT NULL,
telefone varchar(30) DEFAULT NULL,
data_nascimento date NOT NULL,
endereco varchar(255) NOT NULL,
PRIMARY KEY (id)
);

-- cria tabela tb_livros
CREATE TABLE tb_livros(
isbn int NOT NULL,
titulo varchar(100) NOT NULL,
edicao varchar(20) NOT NULL,
sinopse varchar(2000) DEFAULT NULL,
ano_lancamento date NOT NULL,
qtde_estoque int DEFAULT 0,
num_paginas int DEFAULT NULL,
idioma varchar(30) DEFAULT NULL,
dimensoes varchar(50) DEFAULT NULL,
capa char(1) DEFAULT NULL,
genero varchar(50) NOT NULL,
categoria varchar(50) NOT NULL,
autor varchar(50) NOT NULL,
editora varchar(50) NOT NULL,
PRIMARY KEY (isbn)
);

-- cria tabela tb_emprestimos
CREATE TABLE tb_emprestimos(
id int NOT NULL auto_increment,
data_emprestimo date NOT NULL,
data_devolucao date NOT NULL,
PRIMARY KEY (id)
);

-- tabelas de relacionamento

-- cria tabela tb_cliente_emprestimo
CREATE TABLE tb_cliente_emprestimo(
id int NOT NULL auto_increment,
id_cliente int NOT NULL,
id_emprestimo int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_cliente) REFERENCES tb_clientes(id),
FOREIGN KEY (id_emprestimo) REFERENCES tb_emprestimos(id)
);

-- cria tabela tb_livro_emprestimo
CREATE TABLE tb_livro_emprestimo(
id int NOT NULL auto_increment,
isbn int NOT NULL,
id_emprestimo int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (isbn) REFERENCES tb_livros(isbn),
FOREIGN KEY (id_emprestimo) REFERENCES tb_emprestimos(id)
);