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
    private Boolean ativo;

    public Jogador(DadosCadastroJogador dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.fornecedor = dados.fornecedor();
        this.posicao = dados.posicao();
        this.pe = dados.pe();
    }

    public void atualizarInformacoes(DadosAtualizaJogador dados) {
        if(dados.idade() != null){
            this.idade = dados.idade();
        }
        if(dados.fornecedor() != null){
            this.fornecedor = dados.fornecedor();
        }
        if(dados.posicao() != null){
            this.posicao = dados.posicao();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
