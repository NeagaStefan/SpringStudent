package com.student.springstudent.Error;

public class EmptyListException extends RuntimeException{
    public EmptyListException() {
        super();
    }

    public EmptyListException(String message) {
        super(message);
    }

    public EmptyListException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyListException(Throwable cause) {
        super(cause);
    }

    protected EmptyListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
