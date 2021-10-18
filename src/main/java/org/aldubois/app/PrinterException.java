package org.aldubois.app;


public class PrinterException extends RuntimeException {
    
    public PrinterException(String msg) {
        super(msg);
    }

    public PrinterException(String msg, Throwable err) {
        super(msg, err);
    }
}
