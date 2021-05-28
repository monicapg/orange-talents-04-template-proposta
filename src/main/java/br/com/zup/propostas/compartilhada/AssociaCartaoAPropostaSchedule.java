package br.com.zup.propostas.compartilhada;

import br.com.zup.propostas.cartoes.NovoCartaoService;
import br.com.zup.propostas.novaProposta.Proposta;
import br.com.zup.propostas.novaProposta.PropostaRepository;
import br.com.zup.propostas.novaProposta.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
@EnableAsync
public class AssociaCartaoAPropostaSchedule {

    @Autowired
    NovoCartaoService novoCartaoService;

    @Autowired
    private PropostaRepository propostaRepository;

    public List<Proposta> listaPropostasElegiveis () {

        return propostaRepository.findAllByStatus(Status.ELEGIVEL);
    }

    @Scheduled(fixedDelay = 10000)
    public void AssociaCartaoAProposta() {

        List<Proposta> lista = listaPropostasElegiveis();

        for (Proposta proposta : lista) {
            novoCartaoService.gravar(proposta);

        }
    }
}
