package football.api.jogador;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//JPA = Java Persistence API
@Table(name = "jogadores")
@Entity(name = "Jogador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    @Enumerated(EnumType.STRING)
    private Posicao posicao;
    @Enumerated(EnumType.STRING)
    private Pe pe;
    private String fornecedor;

    public Jogador(DadosCadastroJogador dados) {
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.fornecedor = dados.fornecedor();
        this.posicao = dados.posicao();
        this.pe = dados.pe();
    }
}
