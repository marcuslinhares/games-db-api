package dev.marcus.games_db_api.services.impls;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroConsoleDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroConsoleDTO;
import dev.marcus.games_db_api.domain.entities.ConsoleEntity;
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

    @Override
    public Page<ResRegistroConsoleDTO> findall(Pageable pageable) {
        return this.consoleRepository.findAll(pageable).map(
            console -> {
                return ConsoleMapper.fromEntityToResRegistroDTO(console);
            }
        );
    }

    @Override
    public ResRegistroConsoleDTO findById(Long id) {
        return ConsoleMapper.fromEntityToResRegistroDTO(
            this.consoleRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Console não encontrado na base de dados!"
                )
            )
        );
    }

    @Override
    @Transactional
    public ResRegistroConsoleDTO update(ReqRegistroConsoleDTO dto, Long id) {
        var consoleParaEditar = this.findEntityById(id);
        ConsoleMapper.fromRegistroDTOToEntityUpdate(
            consoleParaEditar,
            dto
        );
        return ConsoleMapper.fromEntityToResRegistroDTO(
            this.consoleRepository.save(consoleParaEditar)
        );
    }

    @Override
    @Transactional
    public ResRegistroConsoleDTO delete(Long id) {
        var consoleParaExcluir = this.findEntityById(id);
        this.consoleRepository.delete(consoleParaExcluir);
        return ConsoleMapper.fromEntityToResRegistroDTO(consoleParaExcluir);
    }

    public ConsoleEntity findEntityById(Long id){
        return this.consoleRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Console não existe na base de dados!"
            )
        );
    }
}
