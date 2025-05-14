package dev.marcus.games_db_api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.entities.DesenvolvedorEntity;

public interface DesenvolvedorService {
    ResRegistroDesenvolvedorDTO save(ReqRegistroDesenvolvedorDTO dto);
    Page<ResRegistroDesenvolvedorDTO> findAll(Pageable pageable);
    ResRegistroDesenvolvedorDTO findById(Long id);
    DesenvolvedorEntity findEntityById(Long id);
    ResRegistroDesenvolvedorDTO update(ReqRegistroDesenvolvedorDTO dto, Long id);
    ResRegistroDesenvolvedorDTO delete(Long id);
}
