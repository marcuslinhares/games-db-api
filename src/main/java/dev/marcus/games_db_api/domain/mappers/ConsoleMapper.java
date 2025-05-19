package dev.marcus.games_db_api.domain.mappers;

import dev.marcus.games_db_api.domain.DTOs.requests.ReqRegistroConsoleDTO;
import dev.marcus.games_db_api.domain.DTOs.responses.ResRegistroConsoleDTO;
import dev.marcus.games_db_api.domain.entities.ConsoleEntity;

public abstract class ConsoleMapper {
    public static ConsoleEntity fromReqRegistroDTOtoEntity(
        ReqRegistroConsoleDTO console
    ){
        return ConsoleEntity.builder()
            .nome(console.nome())
            .dataLancamento(console.dataLancamento())
            .empresa(console.empresa())
        .build();
    }

    public static ResRegistroConsoleDTO fromEntityToResRegistroDTO(
        ConsoleEntity console
    ){
        return new ResRegistroConsoleDTO(
            console.getCodigo(), console.getNome(), console.getDataLancamento(),
            console.getEmpresa()
        );
    }

    public static void fromRegistroDTOToEntityUpdate(
        ConsoleEntity console, ReqRegistroConsoleDTO dto
    ){
        console.setNome(dto.nome());
        console.setDataLancamento(dto.dataLancamento());
        console.setEmpresa(dto.empresa());
    }
}
