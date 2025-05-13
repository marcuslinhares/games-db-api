package dev.marcus.games_db_api.services;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroDesenvolvedorDTO;

public interface DesenvolvedorService {
    ResRegistroDesenvolvedorDTO save(ReqRegistroDesenvolvedorDTO dto);
}
