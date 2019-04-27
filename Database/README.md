Para criar o banco de dados que foi modelado pelo grupo para o projeto basta copiar os comandos abaixo, colar na tab de
query do seu MYSQL Workbench e executar.

~~~
CREATE DATABASE `koren` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

use koren;

CREATE TABLE `usuario` (
  `username` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `email` varchar(120) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `postagem` (
  `titulo` varchar(50) NOT NULL,
  `texto` varchar(800) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` datetime NOT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `postagem_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `usuario` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `comentario` (
  `texto` varchar(800) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` datetime NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `post_id` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `post_id` (`post_id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `comentario_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `usuario` (`username`),
  CONSTRAINT `comentario_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `postagem` (`id`),
  CONSTRAINT `comentario_ibfk_3` FOREIGN KEY (`parent_id`) REFERENCES `comentario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tag` (
  `tag_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
~~~
