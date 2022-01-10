package org.resfa.exception;

public class HandledServiceException extends Exception {

    public HandledServiceException(String errorMessage) {
        super(errorMessage);
    }

    public HandledServiceException(String errorMessage, Exception e) {
        super(errorMessage, e);
    }
}
