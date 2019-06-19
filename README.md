# Koren WebApp

Projeto de um Forúm para pais de pessoas com síndrome de Down.

Desenvolvido em Java, utilizando Hibernate, JSP, JPA, Servlet e um banco de dados no PostgreSQL.

# Rodando o programa

###Dependencias: 
- [Apache Tomcat 7 ou mais](https://tomcat.apache.org/)
- [PostgreSQL](https://www.postgresql.org/)
- Eclipse Java EE ou qualquer outra IDE que tenha suporte à projetos Maven.

## Antes de executar

Por padrão está sendo usado o usuário padrão do PostgreSQL chamado "postgres", com a senha "admin". (Teste via banco de dados local)

_Caso queira usar outra configuração do banco de dados, se deve modificar o arquivo [hibernate.cfg.xml](./src/hibernate.cfg.xml)._

Na pasta [Database](./Database) já se encontra o script para a criação do schema, tabelas e elementos do banco de dados. 

## Executando

Com o banco de dados iniciado e o schema criado, é só rodar o arquivo `home.jsp` e se divertir.

