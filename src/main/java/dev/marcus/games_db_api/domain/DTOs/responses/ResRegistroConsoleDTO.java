package dev.marcus.games_db_api.domain.DTOs.responses;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record ResRegistroConsoleDTO(
    Long codigo,
    String nome,
    LocalDate dataLancamento,
    String empresa
) {

}
