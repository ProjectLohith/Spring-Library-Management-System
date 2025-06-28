package org.gfg.Spring_Minor.controller;


import lombok.extern.slf4j.Slf4j;
import org.gfg.Spring_Minor.exceptions.TransactionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//this will call when ever in transaction controller any error occur with the given TransactionException class then this will run.
//so the link from which this is executed is through TransactionException exception because we won't specify this in any controller class explictly.
//this will reside in between the controller and client layers to handle exceptions. It not's between in controller and service

@ControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {

    @ExceptionHandler(value = TransactionException.class)
    public ResponseEntity<String> takeAction(TransactionException transactionException) {
        log.error("transactionException occurred: {}", transactionException);
        return new ResponseEntity<>(transactionException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
