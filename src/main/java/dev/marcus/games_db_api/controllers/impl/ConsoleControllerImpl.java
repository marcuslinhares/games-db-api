package dev.marcus.games_db_api.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Override
    @GetMapping
    public ResponseEntity<Page<ResRegistroConsoleDTO>> findAll(
        @RequestParam int page, @RequestParam int size
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.consoleService.findall(PageRequest.of(page, size))
        );
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ResRegistroConsoleDTO> findById(
        @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(this.consoleService.findById(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ResRegistroConsoleDTO> update(
        @RequestBody @Valid ReqRegistroConsoleDTO dto, 
        @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.consoleService.update(dto, id)
        );
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ResRegistroConsoleDTO> delete(
        @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(this.consoleService.delete(id));
    }

}
