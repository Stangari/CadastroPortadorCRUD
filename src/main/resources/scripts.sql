CREATE TABLE portador (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(14)NOT NULL,
    cpf VARCHAR(14) NOT NULL
)