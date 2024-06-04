ALTER TABLE tb_livros
MODIFY COLUMN edicao varchar(100) NOT NULL;

ALTER TABLE tb_livros
MODIFY COLUMN qtde_estoque int NOT NULL;

ALTER TABLE tb_clientes
MODIFY COLUMN cpf char(11) UNIQUE NOT NULL;

ALTER TABLE tb_funcionarios
DROP COLUMN username;

ALTER TABLE tb_funcionarios
ADD COLUMN cpf char(11) UNIQUE NOT NULL;