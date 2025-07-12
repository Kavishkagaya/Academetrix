package com.academetrics.backend.Exceptions;

public class UsernameAlreadyExistException extends RuntimeException{
    public UsernameAlreadyExistException(String username) {
        super("Username '" + username + "' is already in use");
    }
}
