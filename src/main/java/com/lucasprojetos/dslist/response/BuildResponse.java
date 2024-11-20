package com.lucasprojetos.dslist.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BuildResponse {

    public <T> ResponseEntity<Response<T>> build(String status, String message, T data, HttpStatus httpStatus) {
        Response<T> response = new Response<>(status, message, data);
        return ResponseEntity.status(httpStatus).body(response);
    }
}
