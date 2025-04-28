package med.voll.api.validacao.consulta.agendamento;

import med.voll.api.entities.consulta.dto.ConsultaDTOAgendamento;
import med.voll.api.entities.paciente.Paciente;
import med.voll.api.repositories.paciente.PacienteRepository;
import med.voll.api.validacao.consulta.abstracao.ValidacaoAgendamentoConsulta;
import med.voll.api.validacao.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPacienteAtivo implements ValidacaoAgendamentoConsulta {

    @Autowired
    private PacienteRepository repository;

    @Override
    public void validar(ConsultaDTOAgendamento dados) {
        Paciente paciente = repository.getReferenceById(dados.pacienteId());

        if (!paciente.getStatus()) {
            throw new ValidacaoException("Paciente inativo");
        }
    }
}
