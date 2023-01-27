CREATE SCHEMA loja_virtual;
USE loja_virtual;

CREATE TABLE produto(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255)
);


INSERT INTO produto(nome, descricao) VALUES('Notebook', 'Notebook Samsung');
INSERT INTO produto(nome, descricao) VALUES('Cadeira Gamer', 'Ergonômica');

CREATE TABLE categoria(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR (50) NOT NULL
) ENGINE = InnoDB;

INSERT INTO categoria (nome) VALUES ('Eletronico');
INSERT INTO categoria (nome) VALUES ('Eletrodomestico');
INSERT INTO categoria (nome) VALUES ('Moveis');

ALTER TABLE produto
ADD COLUMN categoria_id INT;

ALTER TABLE produto
    ADD FOREIGN KEY (categoria_id)
    REFERENCES categoria(id);

SELECT p.nome as `Nome`, p.descricao as `Descrição`, c.nome as `Categoria` FROM produto as p
INNER JOIN categoria as c
ON p.categoria_id = c.id;
