package dev.marcus.games_db_api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroDesenvolvedorDTO;

public interface DesenvolvedorService {
    ResRegistroDesenvolvedorDTO save(ReqRegistroDesenvolvedorDTO dto);
    Page<ResRegistroDesenvolvedorDTO> findAll(Pageable pageable);
    ResRegistroDesenvolvedorDTO update(ReqRegistroDesenvolvedorDTO dto, Long id);
}
