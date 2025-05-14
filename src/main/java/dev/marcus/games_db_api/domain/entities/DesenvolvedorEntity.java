package dev.marcus.games_db_api.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "desenvolvedor")
@Table(name = "desenvolvedor", schema = "gamesdb")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "codigo")
@Builder
public class DesenvolvedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private LocalDate dataFundacao;

    private String website;

    private String sede;

    @OneToMany(
        mappedBy = "desenvolvedor",
        cascade = CascadeType.REMOVE,
        orphanRemoval = true
    )
    private List<JogoEntity> jogos;
}
