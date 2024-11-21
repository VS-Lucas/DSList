package com.lucasprojetos.dslist.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucasprojetos.dslist.response.BuildResponse;
import com.lucasprojetos.dslist.response.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private BuildResponse buildResponse;

    @ExceptionHandler({GameNotFoundException.class})
    public ResponseEntity<Response<String>> handleGameNotFoundException(GameNotFoundException exception) {
        return buildResponse.build("error", exception.getMessage(), HttpStatus.NOT_FOUND);        
    }

    @ExceptionHandler({GameListNotFoundException.class})
    public ResponseEntity<Response<String>> handleGameListNotFoundException(GameListNotFoundException exception) {
        return buildResponse.build("error", exception.getMessage(), HttpStatus.NOT_FOUND);        
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Response<String>> handleRuntimeException(RuntimeException exception) {
        return buildResponse.build("error", "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);  
    }
}
