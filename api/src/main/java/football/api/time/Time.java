package football.api.time;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import football.api.jogador.DadosAtualizaJogador;
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
    private Boolean ativo;

    public Time(DadosCadastroTime dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.estadio = dados.estadio();
        this.fundacao = LocalDate.parse(dados.fundacao());
        this.patrocinador = dados.patrocinador();
        this.mascote = dados.mascote();
    }

    public void atualizarInformacoes(DadosAtualizaTime dados) {
        if(dados.estadio() != null){
            this.estadio = dados.estadio();
        }
        if(dados.patrocinador() != null){
            this.patrocinador = dados.patrocinador();
        }
        if(dados.mascote() != null){
            this.mascote = dados.mascote();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
