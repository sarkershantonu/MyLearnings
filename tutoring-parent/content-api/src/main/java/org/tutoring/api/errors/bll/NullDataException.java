package org.tutoring.api.errors.bll;

import org.tutoring.api.errors.APIMessages;

public class NullDataException extends Exception {

    public NullDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullDataException(String message) {
        super(message);
    }
}
