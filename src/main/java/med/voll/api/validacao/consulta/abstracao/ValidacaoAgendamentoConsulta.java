package med.voll.api.validacao.consulta.abstracao;

import med.voll.api.entities.consulta.dto.ConsultaDTOAgendamento;

public interface ValidacaoAgendamentoConsulta {

    void validar(ConsultaDTOAgendamento dados);
}
