package org.Medical.exceptions;

public class DuplicateUserFoundException  extends RuntimeException {

    public DuplicateUserFoundException(String message) {
        super(message);
    }
}

