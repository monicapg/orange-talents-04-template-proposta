package br.com.zup.propostas.compartilhada;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collection;

@RestControllerAdvice
public class PropostasHandlerAdvice {

    @ExceptionHandler(ApiErrorException.class)
    public ResponseEntity<ErroPadronizado> handleApiErrorException(ApiErrorException apiErrorException) {
        Collection<String> messages = new ArrayList<>();
        messages.add(apiErrorException.getReason());

        ErroPadronizado erroPadronizado = new ErroPadronizado(messages);
        return ResponseEntity.status(apiErrorException.getHttpStatus()).body(erroPadronizado);
    }
}
