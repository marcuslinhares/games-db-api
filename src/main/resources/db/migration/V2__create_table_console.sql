CREATE TABLE console (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_lancamento DATE NOT NULL,
    empresa VARCHAR(100)
);
