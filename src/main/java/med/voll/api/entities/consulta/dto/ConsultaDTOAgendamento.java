package med.voll.api.entities.consulta.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.medico.dto.Especialidade;

import java.time.LocalDateTime;

public record ConsultaDTOAgendamento(
        Long medicoId,
        Especialidade especialidade,
        @NotNull
        Long pacienteId,
        @NotNull @Future
        LocalDateTime data
) {
}
