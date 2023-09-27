package football.api.jogador;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
NotBlank apenas para string e NotNull para enum ints e etc

@Valid - para outros DTO que estejam entre os atributos de um outro DTO - Validar se esta tudo certo
@Pattern - para colocar um padrao para recebimeto dos dados
*/
public record DadosCadastroJogador(

        @NotBlank
        String nome,
        @NotNull
        Integer idade,
        @NotNull
        String fornecedor,
        @NotNull
        Posicao posicao,
        @NotNull
        Pe pe) {
}
