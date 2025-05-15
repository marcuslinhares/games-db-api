package dev.marcus.games_db_api.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Override
    @GetMapping
    public ResponseEntity<Page<ResRegistroJogoDTO>> findAll(
        @RequestParam int page, @RequestParam int size
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.jogoService.findAll(PageRequest.of(page, size))
        );
    }

    @Override
    @GetMapping(path = "/desenvolvedor/{id}")
    public ResponseEntity<Page<ResRegistroJogoDTO>> findByDesenvolvedor(
        @PathVariable Long id, @RequestParam int page, @RequestParam int size
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.jogoService.findByDesenvolvedor(
                PageRequest.of(page, size), id
            )
        );
    }

    @Override
    @GetMapping(path = "/console/{id}")
    public ResponseEntity<Page<ResRegistroJogoDTO>> findByConsole(
        @PathVariable Long id, @RequestParam int page, @RequestParam int size
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.jogoService.findByConsole(
                PageRequest.of(page, size), id
            )
        );
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ResRegistroJogoDTO> findById(
        @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.jogoService.findById(id)
        );
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ResRegistroJogoDTO> update(
        @RequestBody @Valid ReqRegistroJogoDTO dto,
        @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.jogoService.update(dto, id)
        );
    }

}
