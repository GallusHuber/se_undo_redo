package com.example.demo.exceptions;

public class WrongArgumentException extends Exception{
    public WrongArgumentException(){
        super("Could not instantiate Object");
    }
}