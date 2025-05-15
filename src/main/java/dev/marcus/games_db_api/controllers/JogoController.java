package dev.marcus.games_db_api.controllers;

import org.springframework.data.domain.Page;
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

    @Operation(
        summary = "Busca todos os jogos do sistema.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<Page<ResRegistroJogoDTO>> findAll(
        int page, int size
    );

    @Operation(
        summary = "Busca todos os jogos de um desenvolvedor do sistema.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<Page<ResRegistroJogoDTO>> findByDesenvolvedor(
        Long id, int page, int size
    );

    @Operation(
        summary = "Busca todos os jogos de um console do sistema.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<Page<ResRegistroJogoDTO>> findByConsole(
        Long id, int page, int size
    );

    @Operation(
        summary = "Busca um jogo pelo id.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroJogoDTO> findById(Long id);

    @Operation(
        summary = "Atualiza um jogo do sistema pelo id.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroJogoDTO> update(
        ReqRegistroJogoDTO dto, Long id
    );
}
