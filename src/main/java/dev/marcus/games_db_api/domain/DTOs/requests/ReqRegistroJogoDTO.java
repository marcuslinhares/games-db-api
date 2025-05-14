package dev.marcus.games_db_api.domain.DTOs.requests;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ReqRegistroJogoDTO(
    @NotBlank(message = "O nome é obrigatório")
    String nome,
    
    String descricao,

    @NotNull(message = "A data de lançamento é obrigatória")
    LocalDate dataLancamento,

    String website,
    String genero,
    String urlCapa,

    @NotNull(message = "A data de lançamento é obrigatória")
    Long desenvolvedor,

    @NotEmpty(message = "Pelo menos um console deve ser informado")
    List<Long> consoles
) {

}
