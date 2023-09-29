package football.api.time;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Table(name = "times")
@Entity(name = "Time")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String estadio;
    private LocalDate fundacao;
    private String patrocinador;
    private String mascote;

    public Time(DadosCadastroTime dados) {
        this.nome = dados.nome();
        this.estadio = dados.estadio();
        this.fundacao = LocalDate.parse(dados.fundacao());
        this.patrocinador = dados.patrocinador();
        this.mascote = dados.mascote();
    }
}
