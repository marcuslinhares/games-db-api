CREATE TABLE jogo_console (
    jogo_codigo INT NOT NULL,
    console_codigo INT NOT NULL,
    PRIMARY KEY (jogo_codigo, console_codigo),
    FOREIGN KEY (jogo_codigo) REFERENCES jogo(codigo) ON DELETE CASCADE,
    FOREIGN KEY (console_codigo) REFERENCES console(codigo) ON DELETE CASCADE
);
