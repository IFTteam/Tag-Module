package com.intellipro.customer.journey.demo.error;

public class JourneyNotFoundException extends Exception{

    public JourneyNotFoundException() {
        super();
    }

    public JourneyNotFoundException(String message) {
        super(message);
    }

    public JourneyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public JourneyNotFoundException(Throwable cause) {
        super(cause);
    }

    protected JourneyNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
