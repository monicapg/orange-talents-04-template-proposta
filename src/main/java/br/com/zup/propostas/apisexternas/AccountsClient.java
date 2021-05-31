package br.com.zup.propostas.apisexternas;

import br.com.zup.propostas.cartoes.AssociacaoDeCartaoRequest;
import br.com.zup.propostas.cartoes.AssociacaoDeCartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "accounts", url = "http://contas:8888") //não roda localhost no docker
public interface AccountsClient {

    @RequestMapping(method = RequestMethod.GET, path = "/api/cartoes",
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AssociacaoDeCartaoResponse> consultaCartao(@RequestParam("idProposta") String idProposta);

}
