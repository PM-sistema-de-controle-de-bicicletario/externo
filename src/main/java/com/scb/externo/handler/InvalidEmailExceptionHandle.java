package com.scb.externo.handler;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.scb.externo.models.erros.InvalidEmailError;
import com.scb.externo.models.exceptions.ResourceInvalidEmailException;

@ControllerAdvice
public class InvalidEmailExceptionHandle {

    private Random geradorId = new Random();

    @ExceptionHandler(ResourceInvalidEmailException.class)
    public ResponseEntity<InvalidEmailError> handleResourceInvalidEmailException(ResourceInvalidEmailException exception) {
        InvalidEmailError error = new InvalidEmailError(Integer.toString(geradorId.nextInt(25)), HttpStatus.UNPROCESSABLE_ENTITY.value(), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
}
