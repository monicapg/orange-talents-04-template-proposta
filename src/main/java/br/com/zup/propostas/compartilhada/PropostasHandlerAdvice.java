package br.com.zup.propostas.compartilhada;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class PropostasHandlerAdvice {

    @ExceptionHandler(ApiErrorException.class)
    public ResponseEntity<ErroPadronizado> handleApiErrorException(ApiErrorException apiErrorException) {
        Collection<String> messages = new ArrayList<>();
        messages.add(apiErrorException.getReason());

        ErroPadronizado erroPadronizado = new ErroPadronizado(messages);
        return ResponseEntity.status(apiErrorException.getHttpStatus()).body(erroPadronizado);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadronizado> handle(MethodArgumentNotValidException methodArgumentNotValidException) {
        Collection<String> messages = new ArrayList<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            String message = String.format("Campo '%s' %s", fieldError.getField(), fieldError.getDefaultMessage());
            messages.add(message);
        });

        ErroPadronizado erroPadronizado = new ErroPadronizado(messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadronizado);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleContraintViolationException(
            ConstraintViolationException constraintViolationException) {
        Collection<String> messages = new ArrayList<>();
        //messages.add("Endereço com campo inválido");
        ErroPadronizado erroPadronizado = new ErroPadronizado(messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Endereço com campo inválido.");
    }
}
