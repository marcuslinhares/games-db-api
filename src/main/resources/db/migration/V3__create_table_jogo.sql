CREATE TABLE jogo (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    data_lancamento DATE NOT NULL,
    website VARCHAR(255),
    genero VARCHAR(50),
    url_capa VARCHAR(255),
    desenvolvedor_codigo INT NOT NULL,
    FOREIGN KEY (desenvolvedor_codigo) REFERENCES desenvolvedor(codigo)
);
