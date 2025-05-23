package dev.marcus.games_db_api.controllers;

import org.springframework.data.domain.Page;
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
        summary = "Cadastra novo desenvolvedor no sistema.",
        responses = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroDesenvolvedorDTO> save(
        ReqRegistroDesenvolvedorDTO dto,
        UriComponentsBuilder uriBuilder
    );

    @Operation(
        summary = "Busca todos os desenvolvedores do sistema.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<Page<ResRegistroDesenvolvedorDTO>> findAll(
        int page, int size
    );

    @Operation(
        summary = "Busca um desenvolvedor pelo id.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroDesenvolvedorDTO> findById(Long id);

    @Operation(
        summary = "Atualiza um desenvolvedor do sistema pelo id.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroDesenvolvedorDTO> update(
        ReqRegistroDesenvolvedorDTO dto, Long id
    );

    @Operation(
        summary = "Apaga um desenvolvedor do sistema pelo id.",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    ResponseEntity<ResRegistroDesenvolvedorDTO> delete(Long id);
}
