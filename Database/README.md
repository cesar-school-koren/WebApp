Para criar o banco de dados que foi modelado pelo grupo para o projeto basta copiar os comandos abaixo e colar na tab de query do seu PgAdminIII, ou abrir o arquivo sql que se encontra nesta pasta usando query e executar.

~~~
-- Schema: koren

Create schema "koren"
	Authorization postgres;

CREATE TABLE Koren.Account (
    "account_id" serial   NOT NULL,
    "username" varchar(50)   NOT NULL,
    "password" varchar(50)   NOT NULL,
    "email" varchar(50)   NOT NULL,
    "creation_date" timestamp   NOT NULL,
    "last_login" timestamp   NULL,
    "privilege" integer NOT NULL DEFAULT 1,
    CONSTRAINT "pk_Account" PRIMARY KEY (
        "account_id"
     ),
    CONSTRAINT "uc_Account_username" UNIQUE (
        "username"
    ),
    CONSTRAINT "uc_Account_email" UNIQUE (
        "email"
    )
);

CREATE TABLE Koren.Category (
    "category_id" serial   NOT NULL,
    "title" varchar(200)   NOT NULL,
    CONSTRAINT "pk_Category" PRIMARY KEY (
        "category_id"
     ),
    CONSTRAINT "uc_Category_title" UNIQUE (
        "title"
    )
);

CREATE TABLE Koren.Post (
    "post_id" serial   NOT NULL,
    "account_id" serial   NOT NULL,
    "category_id" serial   NOT NULL,
    "text" text   NOT NULL,
    "title" varchar(50)   NOT NULL,
    "creation_date" timestamp   NOT NULL,
    "tags" text[]   NOT NULL,
    CONSTRAINT "pk_Post" PRIMARY KEY (
        "post_id"
     )
);

CREATE TABLE Koren.Commentary (
    "commentary_id" serial   NOT NULL,
    "account_id" serial   NOT NULL,
    "post_id" serial   NOT NULL,
    "parent_id" serial,
    "text" text   NOT NULL,
    "creation_date" timestamp   NOT NULL,
    "depth" integer NOT NULL DEFAULT 0,
    CONSTRAINT "pk_Commentary" PRIMARY KEY (
        "commentary_id"
     )
);

ALTER TABLE Koren.Post ADD CONSTRAINT "fk_Post_account_id" FOREIGN KEY("account_id")
REFERENCES Koren.Account ("account_id") ON DELETE CASCADE;

ALTER TABLE Koren.Post ADD CONSTRAINT "fk_Post_category_id" FOREIGN KEY("category_id")
REFERENCES Koren.Category ("category_id") ON DELETE CASCADE;

ALTER TABLE Koren.Commentary ADD CONSTRAINT "fk_Commentary_account_id" FOREIGN KEY("account_id")
REFERENCES Koren.Account ("account_id") ON DELETE CASCADE;

ALTER TABLE Koren.Commentary ADD CONSTRAINT "fk_Commentary_post_id" FOREIGN KEY("post_id")
REFERENCES Koren.Post ("post_id") ON DELETE CASCADE;

ALTER TABLE Koren.Commentary ADD CONSTRAINT "fk_Commentary_parent_id" FOREIGN KEY("parent_id")
REFERENCES Koren.Commentary ("commentary_id") ON DELETE CASCADE;

INSERT INTO koren.category(
            category_id, title)
    VALUES (?, "Zero a Cinco");

INSERT INTO koren.category(
            category_id, title)
    VALUES (?, "Cinco a Dez");

INSERT INTO koren.category(
            category_id, title)
    VALUES (?, "Dez a Quinze");
~~~
