package dev.marcus.games_db_api.services.impls;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroJogoDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroJogoDTO;
import dev.marcus.games_db_api.domain.entities.JogoEntity;
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

    @Override
    public Page<ResRegistroJogoDTO> findAll(Pageable pageable) {
        return this.jogoRepository.findAll(pageable).map(
            jogo -> {
                return JogoMapper.fromEntityToResRegistroDTO(jogo);
            }
        );
    }

    @Override
    public Page<ResRegistroJogoDTO> findByDesenvolvedor(Pageable pageable, Long id) {
        return this.jogoRepository.findByDesenvolvedor_Codigo(id, pageable).map(
            jogo -> {
                return JogoMapper.fromEntityToResRegistroDTO(jogo);
            }
        );
    }

    @Override
    public Page<ResRegistroJogoDTO> findByConsole(Pageable pageable, Long id) {
        return this.jogoRepository.findByConsoles_Codigo(id, pageable).map(
            jogo -> {
                return JogoMapper.fromEntityToResRegistroDTO(jogo);
            }
        );
    }

    @Override
    public ResRegistroJogoDTO findById(Long id) {
        return JogoMapper.fromEntityToResRegistroDTO(
            this.findEntityById(id)
        );
    }

    @Override
    @Transactional
    public ResRegistroJogoDTO update(ReqRegistroJogoDTO dto, Long id) {
        var jogoParaEditar = this.findEntityById(id);
        JogoMapper.fromReqRegistroDTOtoEntityUpdate(
            jogoParaEditar,
            dto, this.desenvolvedorService.findEntityById(dto.desenvolvedor()),
            dto.consoles().stream().map(this.consoleService::findEntityById).toList()
        );
        
        return JogoMapper.fromEntityToResRegistroDTO(
            this.jogoRepository.save(jogoParaEditar)
        );
    }

    @Override
    @Transactional
    public ResRegistroJogoDTO delete(Long id) {
        var jogoParaExcluir = this.findEntityById(id);
        this.jogoRepository.delete(jogoParaExcluir);
        return JogoMapper.fromEntityToResRegistroDTO(jogoParaExcluir);
    }

    private JogoEntity findEntityById(Long id){
        return this.jogoRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "jogo não existente na base de dados!"
            )
        );
    }
}
