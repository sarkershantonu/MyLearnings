package org.tutoring.api.errors.bll;

import org.tutoring.api.errors.APIMessages;

//todo
public class NullResultException extends Exception {

    public NullResultException(Throwable cause) {
        super(APIMessages.NO_RESULT, cause);
    }

    public NullResultException(String message) {
        super(message);
    }
}
