package med.voll.api.entities.consulta.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.consulta.ConsultaMotivoCancelamento;

public record ConsultaDTOCancelamento(
        @NotNull
        Long id,
        @NotNull
        ConsultaMotivoCancelamento motivo
) {
}
