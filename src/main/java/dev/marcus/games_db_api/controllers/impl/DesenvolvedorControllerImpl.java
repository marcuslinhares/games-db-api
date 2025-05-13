package dev.marcus.games_db_api.controllers.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.marcus.games_db_api.controllers.DesenvolvedorController;
import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.services.DesenvolvedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/desenvolvedor")
public class DesenvolvedorControllerImpl implements DesenvolvedorController{
    private final DesenvolvedorService desenvolvedorService;

    @Override
    @PostMapping
    public ResponseEntity<ResRegistroDesenvolvedorDTO> save(
        @RequestBody @Valid ReqRegistroDesenvolvedorDTO dto, UriComponentsBuilder uriBuilder
    ) {
        var response = desenvolvedorService.save(dto);
        var uri = uriBuilder.path("/desenvolvedor/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

}
