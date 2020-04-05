-- Scripts para cria��o do projeto --

CREATE TABLE pessoa (
   cpf VARCHAR(100) NOT NULL,
   nome VARCHAR(100) NOT NULL,
   idade INT NOT NULL,
   sexo VARCHAR(100) NOT NULL,
   senha VARCHAR(100) NOT NULL,
   livros VARCHAR(100) NOT NULL
   PRIMARY KEY (cpf) 
);

CREATE TABLE Livro (
   nome VARCHAR(100) NOT NULL,
   autor VARCHAR(100) NOT NULL,
   ano_lancamento int NOT NULL,
   );


CREATE SEQUENCE S_LIVRO 
	MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 ;