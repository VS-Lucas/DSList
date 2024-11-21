package com.lucasprojetos.dslist.exceptions;

public class GameListNotFoundException extends RuntimeException {
    public GameListNotFoundException(String message) {
        super(message);
    }
}
