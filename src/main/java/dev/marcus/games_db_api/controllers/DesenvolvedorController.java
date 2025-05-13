package dev.marcus.games_db_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroDesenvolvedorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Desenvolvedores")
public interface DesenvolvedorController {
    @Operation(
        summary = "Cadastra novo candidato no sistema.",
        responses = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "409", ref = "conflict"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroDesenvolvedorDTO> save(
        ReqRegistroDesenvolvedorDTO dto,
        UriComponentsBuilder uriBuilder
    );
}
