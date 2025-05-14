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
        var uri = uriBuilder.path("/desenvolvedor/{id}").buildAndExpand(response.codigo()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @Override
    @GetMapping(params = {"page", "size"})
    public ResponseEntity<Page<ResRegistroDesenvolvedorDTO>> findAll(
        @RequestParam int page, @RequestParam int size
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.desenvolvedorService.findAll(PageRequest.of(page, size))
        );
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ResRegistroDesenvolvedorDTO> update(
        @RequestBody @Valid ReqRegistroDesenvolvedorDTO dto,
        @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.desenvolvedorService.update(dto, id)
        );
    }

}
