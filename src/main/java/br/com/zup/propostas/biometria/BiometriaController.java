package br.com.zup.propostas.biometria;

import br.com.zup.propostas.cartoes.Cartao;
import br.com.zup.propostas.cartoes.CartaoRepository;
import br.com.zup.propostas.compartilhada.ApiErrorException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/api/biometria")
public class BiometriaController {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    BiometriaRepository biometriaRepository;

    @PostMapping("/{idCartao}")
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

        URI location = builder.path("/biometria/{id}").buildAndExpand(biometria.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaBiometriaCriada(@PathVariable("id") Long id ) {
        Biometria biometria = biometriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok().body("Biometria cadastrada em: "
                + biometria.getDataDeCadastro().toString());
    }
}
