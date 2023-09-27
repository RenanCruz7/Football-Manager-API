package football.api.time;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroTime(
        @NotBlank
        String nome,
        @NotBlank
        String estadio,
        @NotBlank
        String fundacao,
        @NotBlank
        String patrocinador,
        @NotBlank
        String mascote
) {
}
