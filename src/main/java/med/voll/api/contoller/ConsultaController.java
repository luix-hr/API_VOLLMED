package med.voll.api.contoller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.services.consulta.ConsultaService;
import med.voll.api.entities.consulta.dto.ConsultaDTOAgendamento;
import med.voll.api.entities.consulta.dto.ConsultaDTOCancelamento;
import med.voll.api.entities.consulta.dto.ConsultaDTODetalhamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsultaDTODetalhamento> agendar(
            @RequestBody @Valid ConsultaDTOAgendamento dados,
            UriComponentsBuilder uriBuilder
    ) {
        ConsultaDTODetalhamento dto = service.agendar(dados);

        URI uri = uriBuilder.path("/consultas/{id}").buildAndExpand(dados.medicoId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid ConsultaDTOCancelamento dados) {
        service.cancelar(dados);

        return ResponseEntity.noContent().build();
    }
}
