package med.voll.api.repositories.consulta;

import med.voll.api.entities.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query(value = """
            select c.* from consulta c
            where c.paciente_id = :pacienteId
            and DATE(c.data) = DATE(:data)
            and c.status != "CANCELADA"
            order by rand()
            limit 1
            """, nativeQuery = true)
    Consulta getConsultaComPacienteComConsultaAgendadaNoDia(Long pacienteId, LocalDateTime data);

    Boolean existsByMedicoIdAndDataAndMotivoIsNull(Long medicoId, LocalDateTime data);
}
