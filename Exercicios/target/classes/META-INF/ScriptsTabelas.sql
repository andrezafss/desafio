-- Scripts para cria��o do projeto --

CREATE TABLE pessoa (
   cpf VARCHAR(11) NOT NULL,
   nome VARCHAR(100) NOT NULL,
   idade INT NOT NULL,
   sexo VARCHAR(20) NOT NULL,
   senha VARCHAR(10) NOT NULL,
   PRIMARY KEY (cpf) 
);

CREATE TABLE Livro (
	id NUMBER not null,
   nome VARCHAR(100) NOT NULL,
   autor VARCHAR(100) NOT NULL,
   ano_lancamento int NOT NULL,
   cpf_pessoa VARCHAR(11) NOT NULL,
   PRIMARY KEY (id)
   );


CREATE SEQUENCE S_LIVRO 
	MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 ;
	
	
ALTER TABLE livro
    ADD CONSTRAINT livro_pessoa_fk
    FOREIGN KEY (cpf_pessoa)	
    REFERENCES pessoa(cpf);