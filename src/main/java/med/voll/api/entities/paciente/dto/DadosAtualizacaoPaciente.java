package med.voll.api.entities.paciente.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.endereco.dto.DadosEndereco;

public record DadosAtualizacaoPaciente(

        @NotNull
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco ) {
}
