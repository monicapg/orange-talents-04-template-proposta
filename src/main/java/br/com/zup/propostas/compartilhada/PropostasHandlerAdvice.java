package br.com.zup.propostas.compartilhada;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@RestControllerAdvice
//public class PropostasHandlerAdvice {
//    @ExceptionHandler(MethodArgumentNotValidException)
//    public ResponseEntity<ErroPadronizado> handle(MethodArgumentNotValidException methodArgumentNotValidException) {
//        Collection<String> messages = new ArrayList<>();
//        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
//        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//
//        fieldErrors.forEach(fieldError -> {String message = String
//                .format("Campo %s %s", fieldError.getField(), fieldError.getDefaultMessage());
//            messages.add(message);
//
//        });
//        return null;
//    }
//
//}
