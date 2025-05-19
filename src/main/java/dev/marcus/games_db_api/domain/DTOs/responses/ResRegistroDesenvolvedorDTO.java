package dev.marcus.games_db_api.domain.DTOs.responses;

import java.time.LocalDate;

public record ResRegistroDesenvolvedorDTO(
    Long codigo,
    String nome,
    LocalDate dataFundacao,
    String website, 
    String sede
) {

}
