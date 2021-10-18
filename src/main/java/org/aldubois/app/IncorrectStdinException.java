package org.aldubois.app;


public class IncorrectStdinException extends RuntimeException {
    
    public IncorrectStdinException(String msg) {
        super(msg);
    }

    public IncorrectStdinException(String msg, Throwable err) {
        super(msg, err);
    }
}
