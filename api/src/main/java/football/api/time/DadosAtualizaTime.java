package football.api.time;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaTime(
        @NotNull
        Long id,
        String estadio,
        String patrocinador,
        String mascote
) {
}
