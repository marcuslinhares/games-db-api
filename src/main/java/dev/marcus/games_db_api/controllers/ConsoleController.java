package dev.marcus.games_db_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroConsoleDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroConsoleDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Consoles")
public interface ConsoleController {
    @Operation(
        summary = "Cadastra novo console no sistema.",
        responses = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "409", ref = "conflict"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroConsoleDTO> save(
        ReqRegistroConsoleDTO dto,
        UriComponentsBuilder uriBuilder
    );
}
