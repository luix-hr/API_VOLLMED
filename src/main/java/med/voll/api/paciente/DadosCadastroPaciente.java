package med.voll.api.paciente;


public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {
}