package dev.marcus.games_db_api.services.impls;

import org.springframework.stereotype.Service;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroJogoDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroJogoDTO;
import dev.marcus.games_db_api.domain.mappers.JogoMapper;
import dev.marcus.games_db_api.repositories.JogoRepository;
import dev.marcus.games_db_api.services.ConsoleService;
import dev.marcus.games_db_api.services.DesenvolvedorService;
import dev.marcus.games_db_api.services.JogoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JogoServiceImpl implements JogoService{

    private final JogoRepository jogoRepository;
    private final DesenvolvedorService desenvolvedorService;
    private final ConsoleService consoleService;

    @Override
    @Transactional
    public ResRegistroJogoDTO save(ReqRegistroJogoDTO dto) {
        return JogoMapper.fromEntityToResRegistroDTO(
            this.jogoRepository.save(
                JogoMapper.fromReqRegistroDTOtoEntity(
                    dto, this.desenvolvedorService.findEntityById(dto.desenvolvedor()),
                    dto.consoles().stream().map(this.consoleService::findEntityById).toList()
                )
            )
        );
    }

}
