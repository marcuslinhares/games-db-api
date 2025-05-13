package dev.marcus.games_db_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.games_db_api.domain.entities.DesenvolvedorEntity;

public interface DesenvolvedorRepository extends JpaRepository<DesenvolvedorEntity, Long>{

}
