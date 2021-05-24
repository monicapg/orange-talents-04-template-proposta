package br.com.zup.propostas.apisexternas;

import br.com.zup.propostas.novaProposta.AnaliseDaPropostaResponse;
import br.com.zup.propostas.novaProposta.AnaliseDePropostaRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cartoes", url = "http://localhost:9999")
public interface CartoesClient {

    @PostMapping("/api/solicitacao")
    AnaliseDaPropostaResponse consulta(AnaliseDePropostaRequest analiseDePropostaRequest);

}
