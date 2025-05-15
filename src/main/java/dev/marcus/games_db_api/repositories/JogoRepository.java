package dev.marcus.games_db_api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.games_db_api.domain.entities.JogoEntity;

public interface JogoRepository extends JpaRepository<JogoEntity, Long>{
    Page<JogoEntity> findAll(Pageable pageable);
    Page<JogoEntity> findByDesenvolvedor_Codigo(Long codigo, Pageable pageable);
    Page<JogoEntity> findByConsoles_Codigo(Long codigo, Pageable pageable);
}
