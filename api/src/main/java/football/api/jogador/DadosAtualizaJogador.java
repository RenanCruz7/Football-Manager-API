package football.api.jogador;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaJogador(
        @NotNull
        Long id,
        Integer idade,
        String fornecedor,
        Posicao posicao) {

}
