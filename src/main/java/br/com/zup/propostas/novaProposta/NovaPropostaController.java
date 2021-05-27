package br.com.zup.propostas.novaProposta;

import br.com.zup.propostas.apisexternas.CartoesClient;
import br.com.zup.propostas.cartoes.CartaoResponse;
import br.com.zup.propostas.compartilhada.ApiErrorException;
import feign.FeignException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/propostas")
public class NovaPropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private CartoesClient analiseClient;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaPropostaRequest request,
                                      UriComponentsBuilder uriComponentsBuilder) {

        if (propostaRepository.existsByDocumento(request.getDocumento())) {

            throw new ApiErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "Documento já cadastrado");
        }

        Proposta novaProposta = request.paraProposta();
        propostaRepository.save(novaProposta);

        //Consultar dados da proposta salva
        AnaliseDePropostaRequest analiseDePropostaRequest = new AnaliseDePropostaRequest(
                novaProposta.getDocumento(),
                novaProposta.getNome(),
                novaProposta.getId());

        try {
            AnaliseDaPropostaResponse resultadoDaAnalise = analiseClient
                    .consulta(analiseDePropostaRequest);
            Status status = resultadoDaAnalise.status();
            novaProposta.setStatus(status);
        } catch (FeignException.UnprocessableEntity unprocessableEntity) {
            novaProposta.setStatus(Status.NAO_ELEGIVEL);
        }

        propostaRepository.save(novaProposta);

        URI location = uriComponentsBuilder.path("/api/propostas/{id}")
                .buildAndExpand(novaProposta.getId())
                .toUri();

        return ResponseEntity.created(location).body("Proposta cadastrada com sucesso!");
    }

    //035 - Acompanhamento da Proposta
    @GetMapping("/{idProposta}")
    public ResponseEntity<?> consultaStatusDaProposta(@PathVariable("idProposta") Long idProposta) {

        Proposta proposta = propostaRepository.findById(idProposta)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
       // return ResponseEntity.ok(proposta.getStatus());
        return ResponseEntity.ok(new NovaPropostaResponse(proposta));

    }
}
