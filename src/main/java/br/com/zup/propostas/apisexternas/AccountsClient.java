package br.com.zup.propostas.apisexternas;

import br.com.zup.propostas.cartoes.AssociacaoDeCartaoRequest;
import br.com.zup.propostas.cartoes.AssociacaoDeCartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "accounts", url = "http://localhost:9999")
public interface AccountsClient {

    @PostMapping("/api/cartoes")
    AssociacaoDeCartaoResponse consultaCartao(AssociacaoDeCartaoRequest associacaoDeCartaoRequest);
}
