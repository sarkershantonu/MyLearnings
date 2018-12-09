package org.tutoring.api.errors.bll;

import org.tutoring.api.errors.APIMessages;

public class InvalidInputException extends Exception {

    public InvalidInputException(String message, Throwable cause) {
        super(APIMessages.INVALID_DATA +message, cause);
    }

    public InvalidInputException(String message) {
        super(APIMessages.INVALID_DATA +message);
    }
}
