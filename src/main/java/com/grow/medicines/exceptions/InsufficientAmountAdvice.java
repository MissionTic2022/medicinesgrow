package com.grow.medicines.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class InsufficientAmountAdvice {
    @ResponseBody
    @ExceptionHandler(InsufficientAmountException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String InsufficientAmountAdvice(InsufficientAmountException ex) {
        return ex.getMessage();
    }
}
