package dev.marcus.games_db_api.domain.mappers;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroDesenvolvedorDTO;
import dev.marcus.games_db_api.domain.entities.DesenvolvedorEntity;

public abstract class DesenvolvedorMapper {

    public static DesenvolvedorEntity reqRegistroDTOtoEntity(
        ReqRegistroDesenvolvedorDTO desenvolvedor
    ){
        return DesenvolvedorEntity.builder()
            .nome(desenvolvedor.nome())
            .dataFundacao(desenvolvedor.dataFundacao())
            .website(desenvolvedor.website())
            .sede(desenvolvedor.sede())
        .build();
    }

    public static ResRegistroDesenvolvedorDTO entityToResRegistroDTO(
        DesenvolvedorEntity desenvolvedor
    ){
        return new ResRegistroDesenvolvedorDTO(
            desenvolvedor.getCodigo(), desenvolvedor.getNome(), 
            desenvolvedor.getDataFundacao(), desenvolvedor.getWebsite(),
            desenvolvedor.getSede()
        );
    }

    public static void fromRegistroDTOToEntityUpdate(
        DesenvolvedorEntity desenvolvedor, ReqRegistroDesenvolvedorDTO dto
    ){
        desenvolvedor.setNome(dto.nome());
        desenvolvedor.setDataFundacao(dto.dataFundacao());
        desenvolvedor.setSede(dto.sede());
        desenvolvedor.setWebsite(dto.website());
    }
}
