package dev.marcus.games_db_api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.games_db_api.domain.entities.ConsoleEntity;

public interface ConsoleRepository extends JpaRepository<ConsoleEntity, Long>{
    Page<ConsoleEntity> findAll(Pageable pageable);
}
