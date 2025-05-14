package dev.marcus.games_db_api.domain.DTOs.requests;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReqRegistroConsoleDTO(
    @NotBlank(message = "O nome é obrigatório")
    String nome,

    @NotNull(message = "A data de lançamento é obrigatória")
    LocalDate dataLancamento,

    String empresa
) {

}
