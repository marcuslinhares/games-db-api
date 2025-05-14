CREATE TABLE IF NOT EXISTS "gamesdb"."jogo_console" (
    "codigo" SERIAL PRIMARY KEY,
    "jogo_codigo" INT NOT NULL,
    "console_codigo" INT NOT NULL,
    FOREIGN KEY ("jogo_codigo") REFERENCES "gamesdb"."jogo"("codigo") ON DELETE CASCADE,
    FOREIGN KEY ("console_codigo") REFERENCES "gamesdb"."console"("codigo") ON DELETE CASCADE
);
