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
        return ResRegistroDesenvolvedorDTO.builder()
            .codigo(desenvolvedor.getCodigo())
            .nome(desenvolvedor.getNome())
            .dataFundacao(desenvolvedor.getDataFundacao())
            .website(desenvolvedor.getWebsite())
            .sede(desenvolvedor.getSede())
        .build();
    }
}
