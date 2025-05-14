package dev.marcus.games_db_api.services.impls;

import org.springframework.stereotype.Service;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroConsoleDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroConsoleDTO;
import dev.marcus.games_db_api.domain.mappers.ConsoleMapper;
import dev.marcus.games_db_api.repositories.ConsoleRepository;
import dev.marcus.games_db_api.services.ConsoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsoleServiceImpl implements ConsoleService{
    private final ConsoleRepository consoleRepository;

    @Override
    @Transactional
    public ResRegistroConsoleDTO save(ReqRegistroConsoleDTO dto) {
        return ConsoleMapper.fromEntityToResRegistroDTO(
            this.consoleRepository.save(
                ConsoleMapper.fromReqRegistroDTOtoEntity(dto)
            )
        );
    }

}
