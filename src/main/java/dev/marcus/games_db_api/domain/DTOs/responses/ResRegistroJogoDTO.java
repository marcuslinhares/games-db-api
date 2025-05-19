package dev.marcus.games_db_api.domain.DTOs.responses;

import java.time.LocalDate;
import java.util.List;

public record ResRegistroJogoDTO(
    Long codigo,
    String nome,
    String descricao,
    LocalDate dataLancamento,
    String website,
    String genero,
    String urlCapa,
    Long desenvolvedor,
    List<Long> consoles
) {
    
}
