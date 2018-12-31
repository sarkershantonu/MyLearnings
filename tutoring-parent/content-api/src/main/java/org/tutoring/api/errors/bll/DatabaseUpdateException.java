package org.tutoring.api.errors.bll;

public class DatabaseUpdateException extends Exception {

    public DatabaseUpdateException(String message) {
        super(message);
    }

    public DatabaseUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}