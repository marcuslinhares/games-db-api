package dev.marcus.games_db_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.games_db_api.domain.entities.ConsoleEntity;

public interface ConsoleRepository extends JpaRepository<ConsoleEntity, Long>{
    
}
