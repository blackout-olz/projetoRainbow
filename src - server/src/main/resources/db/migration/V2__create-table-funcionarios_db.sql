/**
 * Author:  xuniro
 * Created: 24 de mai. de 2024
 */

-- cria tabela funcionario

CREATE TABLE tb_funcionarios(
id int NOT NULL auto_increment,
nome varchar(100) NOT NULL,
username varchar(20) NOT NULL,
passwd varchar(30) NOT NULL,
PRIMARY KEY (id)
);

-- cria adm

INSERT INTO tb_funcionarios(nome, username, passwd) 
VALUES("administrador", "adm", "123");