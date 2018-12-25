package org.tutoring.api.errors.bll;

public class InvalidDataException extends Exception {

    public InvalidDataException(String message, Throwable cause ){
        super(message,cause);
    }
    public InvalidDataException(String message){
        super(message);
    }
}
