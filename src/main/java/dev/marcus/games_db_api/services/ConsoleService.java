package dev.marcus.games_db_api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroConsoleDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroConsoleDTO;
import dev.marcus.games_db_api.domain.entities.ConsoleEntity;

public interface ConsoleService {
    ResRegistroConsoleDTO save(ReqRegistroConsoleDTO dto);
    Page<ResRegistroConsoleDTO> findall(Pageable pageable);
    ResRegistroConsoleDTO findById(Long id);
    ConsoleEntity findEntityById(Long id);
    ResRegistroConsoleDTO update(ReqRegistroConsoleDTO dto, Long id);
    ResRegistroConsoleDTO delete(Long id);
}
