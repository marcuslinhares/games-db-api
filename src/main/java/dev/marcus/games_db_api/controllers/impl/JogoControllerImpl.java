package dev.marcus.games_db_api.controllers.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.marcus.games_db_api.controllers.JogoController;
import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroJogoDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroJogoDTO;
import dev.marcus.games_db_api.services.JogoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/jogo")
@RequiredArgsConstructor
public class JogoControllerImpl implements JogoController{
    private final JogoService jogoService;

    @Override
    @PostMapping
    public ResponseEntity<ResRegistroJogoDTO> save(
        @RequestBody @Valid ReqRegistroJogoDTO dto,
        UriComponentsBuilder uriBuilder
    ) {
        var response = jogoService.save(dto);
        var uri = uriBuilder.path("/jogo/{id}").buildAndExpand(response.codigo()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

}
