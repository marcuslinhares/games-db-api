package dev.marcus.games_db_api.services;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroConsoleDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroConsoleDTO;

public interface ConsoleService {
    ResRegistroConsoleDTO save(ReqRegistroConsoleDTO dto);
}
