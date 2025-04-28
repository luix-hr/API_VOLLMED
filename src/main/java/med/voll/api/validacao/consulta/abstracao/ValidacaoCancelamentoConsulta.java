package med.voll.api.validacao.consulta.abstracao;

import med.voll.api.entities.consulta.dto.ConsultaDTOCancelamento;

public interface ValidacaoCancelamentoConsulta {

    void validar(ConsultaDTOCancelamento dados);
}
