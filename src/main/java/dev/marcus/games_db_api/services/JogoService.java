package dev.marcus.games_db_api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroJogoDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroJogoDTO;

public interface JogoService {
    ResRegistroJogoDTO save(ReqRegistroJogoDTO dto);
    Page<ResRegistroJogoDTO> findAll(Pageable pageable);
    Page<ResRegistroJogoDTO> findByDesenvolvedor(Pageable pageable, Long id);
    Page<ResRegistroJogoDTO> findByConsole(Pageable pageable, Long id);
    ResRegistroJogoDTO findById(Long id);
    ResRegistroJogoDTO update(ReqRegistroJogoDTO dto, Long id);
}
