package br.com.yuri.petx.handlers;

import br.com.yuri.petx.handlers.exception.PetMalFormadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(PetMalFormadoException.class)
    public ResponseEntity<ErroResposta> handlePetMalFormadoException(PetMalFormadoException ex, WebRequest request) {
        return new ResponseEntity<>(new ErroResposta(400, "Pet mal formado: " + ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // Método para capturar outras exceções genéricas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResposta> handleGenericException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErroResposta(500, "Comportamento inesperado."), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
