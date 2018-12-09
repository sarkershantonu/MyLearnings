package org.tutoring.api.errors.bll;

import org.tutoring.api.errors.APIMessages;

public class NullIDException  extends Exception {

    public NullIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullIDException(String message) {
        super(message);
    }
}
