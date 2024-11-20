package com.lucasprojetos.dslist.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BuildResponse {

    public <T> ResponseEntity<Response<T>> build(String status, String message, T data, HttpStatus httpStatus) {
        Response<T> response = new Response<>(status, message, (data == null) ? null : data);
        return ResponseEntity.status(httpStatus).body(response);
    }

    public ResponseEntity<Response<String>> build(String status, String message, HttpStatus httpStatus) {
        return build(status, message, null, httpStatus);
    }
}
