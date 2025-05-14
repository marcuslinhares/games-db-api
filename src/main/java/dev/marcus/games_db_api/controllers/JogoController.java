package dev.marcus.games_db_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroJogoDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroJogoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Desenvolvedores")
public interface JogoController {

    @Operation(
        summary = "Cadastra novo jogo no sistema.",
        responses = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroJogoDTO> save(
        ReqRegistroJogoDTO dto,
        UriComponentsBuilder uriBuilder
    );
}
