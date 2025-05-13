package dev.marcus.games_db_api.services.impls;

import org.springframework.stereotype.Service;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.mappers.DesenvolvedorMapper;
import dev.marcus.games_db_api.repositories.DesenvolvedorRepository;
import dev.marcus.games_db_api.services.DesenvolvedorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DesenvolvedorServiceImpl implements DesenvolvedorService{
    private final DesenvolvedorRepository desenvolvedorRepository;

    @Override
    public ResRegistroDesenvolvedorDTO save(ReqRegistroDesenvolvedorDTO dto) {
        return DesenvolvedorMapper.entityToResRegistroDTO(
            this.desenvolvedorRepository.save(
                DesenvolvedorMapper.reqRegistroDTOtoEntity(dto)
            )
        );
    }
}
