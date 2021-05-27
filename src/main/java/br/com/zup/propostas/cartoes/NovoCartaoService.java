package br.com.zup.propostas.cartoes;

import br.com.zup.propostas.apisexternas.AccountsClient;
import br.com.zup.propostas.novaProposta.Proposta;
import br.com.zup.propostas.novaProposta.PropostaRepository;
import br.com.zup.propostas.novaProposta.Status;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NovoCartaoService {

    @Autowired
    AccountsClient accountsClient;

    @Autowired
    PropostaRepository propostaRepository;

    @Autowired
    CartaoRepository cartaoRepository;

    public Cartao gravar(Proposta proposta) {

        AssociacaoDeCartaoResponse associacaoDeCartaoResponse = null;
    try {
        associacaoDeCartaoResponse = accountsClient.consultaCartao(proposta.getId().toString()).getBody();

        //toModel
        Cartao cartao = associacaoDeCartaoResponse.paraCartao();
        proposta.setCartao(cartao);

        //mudar o status.
        proposta.setStatus(Status.ASSOCIADO);

        //persist
        propostaRepository.save(proposta);


    } catch (FeignException e) {
        System.out.println("Em processamento");

    }

        return null;
    }
}
