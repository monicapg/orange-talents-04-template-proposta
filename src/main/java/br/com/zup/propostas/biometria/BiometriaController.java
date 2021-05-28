package br.com.zup.propostas.biometria;

import br.com.zup.propostas.cartoes.Cartao;
import br.com.zup.propostas.cartoes.CartaoRepository;
import br.com.zup.propostas.compartilhada.ApiErrorException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
public class BiometriaController {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    BiometriaRepository biometriaRepository;

    @PostMapping("/biometria/{idCartao}")
    public ResponseEntity<?> cadastra(@PathVariable Long idCartao,
                                      @RequestParam("biometria") MultipartFile file,
                                      UriComponentsBuilder builder){

        String biometriaString;

        if(file.isEmpty()) {
            throw new ApiErrorException(HttpStatus.BAD_REQUEST, "Biometria inválida");
        }

        if (!cartaoRepository.existsById(idCartao)) {
           throw new ApiErrorException(HttpStatus.NOT_FOUND, "Cartão não encontrado");
        }
        Cartao cartao = cartaoRepository.getOne(idCartao);

        try {
            biometriaString = Base64.encodeBase64String(file.getBytes());
        } catch (IOException e) {
            throw new ApiErrorException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }
        Biometria biometria = new Biometria(biometriaString, cartao);
        biometriaRepository.save(biometria);

        //URI location = builder.path("/{id}").buildAndExpand(biometria.getId()).toUri();
        return ResponseEntity.ok().build();
    }

}
