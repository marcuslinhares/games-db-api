CREATE TABLE desenvolvedor (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_fundacao DATE NOT NULL,
    website VARCHAR(255),
    sede VARCHAR(100)
);
