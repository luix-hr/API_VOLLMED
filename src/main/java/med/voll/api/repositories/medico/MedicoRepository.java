package med.voll.api.repositories.medico;


import med.voll.api.entities.medico.Medico;
import med.voll.api.entities.medico.dto.Especialidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findByStatusTrue(Pageable pageable);

    @Query("""
    select m from Medico m
    where m.status = true
    and m.especialidade = :especialidade
    and m.id not in (
        select c.medico.id from Consulta c
        where c.data = :data
        and c.status != 'CANCELADA'
    )
""")
    Medico escolherMedicoPorEspecialidadeEDataDisponivel(
            @Param("especialidade") Especialidade especialidade,
            @Param("data") LocalDateTime data
    );
}
