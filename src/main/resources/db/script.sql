CREATE SCHEMA loja_virtual;
USE loja_virtual;

CREATE TABLE produto(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255)
);


INSERT INTO produto(nome, descricao) VALUES('Notebook', 'Notebook Samsung');
