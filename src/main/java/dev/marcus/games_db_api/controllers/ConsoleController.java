package dev.marcus.games_db_api.controllers;

import org.springframework.data.domain.Page;
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

    @Operation(
        summary = "Busca todos os consoles do sistema.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<Page<ResRegistroConsoleDTO>> findAll(
        int page, int size
    );

    @Operation(
        summary = "Busca um console pelo id.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroConsoleDTO> findById(Long id);

    @Operation(
        summary = "Atualiza um console do sistema pelo id.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroConsoleDTO> update(
        ReqRegistroConsoleDTO dto, Long id
    );

    @Operation(
        summary = "Apaga um console do sistema pelo id.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroConsoleDTO> delete(Long id);
}
