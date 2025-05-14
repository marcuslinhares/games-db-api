package dev.marcus.games_db_api.controllers.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.marcus.games_db_api.controllers.ConsoleController;
import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroConsoleDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroConsoleDTO;
import dev.marcus.games_db_api.services.ConsoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/console")
@RequiredArgsConstructor
public class ConsoleControllerImpl implements ConsoleController{
    private final ConsoleService consoleService;

    @Override
    @PostMapping
    public ResponseEntity<ResRegistroConsoleDTO> save(
        @RequestBody @Valid ReqRegistroConsoleDTO dto,
        UriComponentsBuilder uriBuilder
    ) {
        var response = this.consoleService.save(dto);
        var uri = uriBuilder.path("/console/{id}").buildAndExpand(response.codigo()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

}
