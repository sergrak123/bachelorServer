package com.example.tesrserver.exeptions;

public class UserNotFoundExeption extends Exception{
    public UserNotFoundExeption(String message) {
        super(message);
    }
}
