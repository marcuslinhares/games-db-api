package dev.marcus.games_db_api.domain.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "jogo")
@Table(name = "jogo", schema = "gamesdb")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "codigo")
@Builder
public class JogoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private String descricao;

    private LocalDate dataLancamento;

    private String website;

    private String genero;

    private String urlCapa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "desenvolvedor_codigo", nullable = false)
    private DesenvolvedorEntity desenvolvedor;
    
    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
        name = "jogo_console",
        schema = "gamesdb",
        joinColumns = @JoinColumn(name = "jogo_codigo"),
        inverseJoinColumns = @JoinColumn(name = "console_codigo")
    )
    private List<ConsoleEntity> consoles;
}
