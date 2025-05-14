package dev.marcus.games_db_api.services;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroJogoDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroJogoDTO;

public interface JogoService {
    ResRegistroJogoDTO save(ReqRegistroJogoDTO dto);
}
