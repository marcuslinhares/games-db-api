package dev.marcus.games_db_api.services.impls;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.entities.DesenvolvedorEntity;
import dev.marcus.games_db_api.domain.mappers.DesenvolvedorMapper;
import dev.marcus.games_db_api.repositories.DesenvolvedorRepository;
import dev.marcus.games_db_api.services.DesenvolvedorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DesenvolvedorServiceImpl implements DesenvolvedorService{
    private final DesenvolvedorRepository desenvolvedorRepository;

    @Override
    @Transactional
    public ResRegistroDesenvolvedorDTO save(ReqRegistroDesenvolvedorDTO dto) {
        return DesenvolvedorMapper.entityToResRegistroDTO(
            this.desenvolvedorRepository.save(
                DesenvolvedorMapper.reqRegistroDTOtoEntity(dto)
            )
        );
    }

    @Override
    public Page<ResRegistroDesenvolvedorDTO> findAll(Pageable pageable) {
        return this.desenvolvedorRepository.findAll(pageable).map(
            desenvolvedor -> {
                return DesenvolvedorMapper.entityToResRegistroDTO(desenvolvedor);
            }
        );
    }

    @Override
    public ResRegistroDesenvolvedorDTO findById(Long id) {
        return DesenvolvedorMapper.entityToResRegistroDTO(
            this.desenvolvedorRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Desenvolvedor não existe na base de dados!"
                )
            )
        );
    }

    @Override
    @Transactional
    public ResRegistroDesenvolvedorDTO update(ReqRegistroDesenvolvedorDTO dto, Long id) {
        var desenvolvedorParaEditar = this.findEntityById(id);
        DesenvolvedorMapper.fromRegistroDTOToEntityUpdate(
            desenvolvedorParaEditar,
            dto
        );
        return DesenvolvedorMapper.entityToResRegistroDTO(
            this.desenvolvedorRepository.save(desenvolvedorParaEditar)
        );
    }
    
    @Override
    @Transactional
    public ResRegistroDesenvolvedorDTO delete(Long id) {
        var desenvolvedorParaExcluir = this.findEntityById(id);
        this.desenvolvedorRepository.delete(desenvolvedorParaExcluir);
        return DesenvolvedorMapper.entityToResRegistroDTO(desenvolvedorParaExcluir);
    }

    private DesenvolvedorEntity findEntityById(Long id){
        return this.desenvolvedorRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Desenvolvedor não existe na base de dados!"
            )
        );
    }
}


