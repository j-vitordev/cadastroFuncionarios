package com.analista.cadastro_email_api.api.exceptionhandler;

import com.analista.cadastro_email_api.domain.exception.FuncionarioExcepion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FuncionarioExcepion.class)
    public ResponseEntity<String> capturar(FuncionarioExcepion e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
    public ResponseEntity<Object> capturarConstraintViolation(jakarta.validation.ConstraintViolationException e) {
        var mensagens = e.getConstraintViolations().stream()
                .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                .toList();

        return ResponseEntity.badRequest().body(mensagens);
    }


}
