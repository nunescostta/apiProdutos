#criando e selecionando o banco de dados
create database db_apiprodutos;
use bd_apiprodutos;

#criar tabela de fornecedores
create table fornecedor(
	id integer auto_increment primary key,
	razaosocial varchar(100) not null,
	cnpj varchar(20) not null
);

#criando tabela de produtos
create table produto(
	id integer auto_increment primary key,
	nome varchar(100) not null,
	preco integer not null,
	quantidade integer not null,
	fornecedor_id integer not null,
	foreign key(fornecedor_id) references fornecedor(id)
);

#cadastrar fornecedores na tabela 

INSERT INTO fornecedor (razaosocial, cnpj) 
VALUES 
    ('ABC Indústria Ltda', '12345678901234'),
    ('XYZ Comércio e Distribuição', '56789012345678'),
    ('LMN Tecnologia S/A', '90123456789012');

#consultando fornecedores
select * from fornecedor