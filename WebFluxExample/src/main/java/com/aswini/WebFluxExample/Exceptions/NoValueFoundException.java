package com.aswini.WebFluxExample.Exceptions;



@SuppressWarnings("serial")
public class NoValueFoundException extends RuntimeException{

    public NoValueFoundException(String message){
        super(message);
    }
}