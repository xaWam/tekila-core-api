package com.jaravir.tekila.module.subscription.exception;

/**
 * Created by sajabrayilov on 12/23/2014.
 */
public class DuplicateAgreementException extends Exception  {
    private final static String DEFAULT_MESSAGE = "Subscriptions with the same agreement %s found";

    public DuplicateAgreementException() {
        super(DEFAULT_MESSAGE);
    }

    public DuplicateAgreementException(String message) {
        super(DEFAULT_MESSAGE + ": " + message);
    }

    public DuplicateAgreementException(String message, Throwable cause) {
        super(DEFAULT_MESSAGE + ": " + message, cause);
    }

    public DuplicateAgreementException(Throwable cause) {
        super(cause);
    }

    public DuplicateAgreementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(DEFAULT_MESSAGE + ": " + message, cause, enableSuppression, writableStackTrace);
    }
}
