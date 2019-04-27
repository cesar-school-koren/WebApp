Para criar o banco de dados que foi modelado pelo grupo para o projeto basta copiar os comandos abaixo, colar na tab de
query do seu PgAdminIII e executar.

~~~
-- Schema: koren

CREATE SCHEMA "koren"
  AUTHORIZATION postgres;

CREATE TABLE koren.CONTA(
 username VARCHAR (50) PRIMARY KEY NOT NULL,
 password VARCHAR (50) NOT NULL,
 email VARCHAR (355) UNIQUE NOT NULL,
 criado_em TIMESTAMP NOT NULL,
 ultimo_login TIMESTAMP
);

CREATE TABLE koren.POSTAGEM(
  titulo varchar(50) NOT NULL,
  texto varchar(800) NOT NULL,
  id SERIAL PRIMARY KEY NOT NULL,
  criado_em timestamp NOT NULL,
  user_id varchar(20) references koren.CONTA(username) NOT NULL,
  tags text[] Not null
);

CREATE TABLE koren.COMENTARIO(
  texto varchar(800) NOT NULL,
  id SERIAL PRIMARY KEY NOT NULL,
  criado_em timestamp NOT NULL,
  user_id varchar(20) references koren.CONTA(username) NOT NULL,
  post_id SERIAL references koren.POSTAGEM(id) NOT NULL,
  parent_id SERIAL,
  FOREIGN KEY (parent_id) 
  REFERENCES koren.comentario (id) 
  ON DELETE CASCADE
);
~~~
