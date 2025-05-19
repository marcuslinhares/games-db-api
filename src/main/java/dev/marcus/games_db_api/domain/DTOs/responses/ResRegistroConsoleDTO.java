package dev.marcus.games_db_api.domain.DTOs.responses;

import java.time.LocalDate;

public record ResRegistroConsoleDTO(
    Long codigo,
    String nome,
    LocalDate dataLancamento,
    String empresa
) {

}
