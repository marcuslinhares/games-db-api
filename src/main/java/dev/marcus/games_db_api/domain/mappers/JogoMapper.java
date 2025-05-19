package dev.marcus.games_db_api.domain.mappers;

import java.util.List;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroJogoDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroJogoDTO;
import dev.marcus.games_db_api.domain.entities.ConsoleEntity;
import dev.marcus.games_db_api.domain.entities.DesenvolvedorEntity;
import dev.marcus.games_db_api.domain.entities.JogoEntity;

public abstract class JogoMapper {
    public static JogoEntity fromReqRegistroDTOtoEntity(
        ReqRegistroJogoDTO dto, DesenvolvedorEntity desenvolvedor, List<ConsoleEntity> consoles
    ){
        return JogoEntity.builder()
            .nome(dto.nome())
            .descricao(dto.descricao())
            .dataLancamento(dto.dataLancamento())
            .website(dto.website())
            .genero(dto.genero())
            .urlCapa(dto.urlCapa())
            .desenvolvedor(desenvolvedor)
            .consoles(consoles)
        .build();
    }

    public static ResRegistroJogoDTO fromEntityToResRegistroDTO(
        JogoEntity jogo
    ){
        return new ResRegistroJogoDTO(
            jogo.getCodigo(), jogo.getNome(), jogo.getDescricao(),
            jogo.getDataLancamento(), jogo.getWebsite(), jogo.getGenero(),
            jogo.getUrlCapa(), jogo.getDesenvolvedor().getCodigo(),
            jogo.getConsoles().stream().map(ConsoleEntity::getCodigo).toList()
        );
    }

    public static void fromReqRegistroDTOtoEntityUpdate(
        JogoEntity jogo, ReqRegistroJogoDTO dto,
        DesenvolvedorEntity desenvolvedor, List<ConsoleEntity> consoles
    ){
        jogo.setNome(dto.nome());
        jogo.setDescricao(dto.descricao());
        jogo.setDataLancamento(dto.dataLancamento());
        jogo.setWebsite(dto.website());
        jogo.setGenero(dto.genero());
        jogo.setUrlCapa(dto.urlCapa());
        jogo.setDesenvolvedor(desenvolvedor);

        if(!consoles.isEmpty()){
            jogo.getConsoles().clear();
            jogo.getConsoles().addAll(consoles);
        }
    }
}
