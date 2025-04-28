package med.voll.api.entities.medico.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.endereco.dto.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco) {

}
