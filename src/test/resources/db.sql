CREATE DATABASE "banco_precos";

CREATE TABLE registros (
	id SERIAL PRIMARY KEY ,
	revenda_instalacao TEXT NOT NULL,
	unidade_de_medida TEXT NOT NULL,
	bandeira TEXT NOT NULL
);

CREATE TABLE endereco(
    id SERIAL PRIMARY KEY,
    registro_id NUMERIC not null,
    regiao TEXT NOT NULL,
    sigla_estado TEXT NOT NULL,
    sigla_municipio TEXT NOT NULL
);

CREATE TABLE produto(
    id SERIAL primary key,
    registro_id NUMERIC NOT NULL,
    codigo_produto TEXT NOT NULL,
    nome_produto TEXT NOT NULL,
    valor_de_compra NUMERIC,
    valor_de_venda NUMERIC NOT NULL,
    data_da_coleta DATE NOT NULL
);

SELECT * FROM registros;
SELECT * FROM endereco;
SELECT * FROM produto;

DELETE FROM registros;
DELETE FROM endereco;
DELETE FROM produto;

DROP TABLE registros;
DROP TABLE endereco;
DROP TABLE produto;

SELECT * FROM endereco WHERE registro_id=1656;