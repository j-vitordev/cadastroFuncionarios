CREATE TABLE funcionario (
                             empresa   VARCHAR(20) NOT NULL,
                             filial    VARCHAR(20) NOT NULL,
                             matricula VARCHAR(20) NOT NULL,
                             nome      VARCHAR(100) NOT NULL,
                             email     VARCHAR(100) NOT NULL,
                             cargo     VARCHAR(100),
                             PRIMARY KEY (empresa, filial, matricula)
);
