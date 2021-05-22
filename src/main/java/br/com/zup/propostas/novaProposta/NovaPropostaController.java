package br.com.zup.propostas.novaProposta;

import br.com.zup.propostas.compartilhada.ApiErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/propostas")
public class NovaPropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaPropostaRequest request,
                                      UriComponentsBuilder uriComponentsBuilder) {

        if (propostaRepository.existsByDocumento(request.getDocumento())) {

            throw new ApiErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "Documento já cadastrado");
        }

        Proposta novaProposta = request.paraProposta();
        propostaRepository.save(novaProposta);

        URI location = uriComponentsBuilder.path("/api/propostas/{id}")
                .buildAndExpand(novaProposta.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
