package med.voll.api.entities.consulta.dto;

import med.voll.api.entities.consulta.Consulta;
import med.voll.api.entities.consulta.ConsultaMotivoCancelamento;
import med.voll.api.entities.consulta.ConsultaStatus;
import med.voll.api.entities.medico.dto.Especialidade;

import java.time.LocalDateTime;

public record ConsultaDTODetalhamento(
        Long id,
        Long medicoId,
        Especialidade especialidade,
        Long pacienteId,
        LocalDateTime data,
        ConsultaStatus status,
        ConsultaMotivoCancelamento motivoCancelamento
) {
    public ConsultaDTODetalhamento(Consulta consulta) {
        this(
                consulta.getId(),
                consulta.getMedico().getId(),
                consulta.getMedico().getEspecialidade(),
                consulta.getPaciente().getId(),
                consulta.getData(),
                consulta.getStatus(),
                consulta.getMotivo()
        );
    }
}
