package com.jaravir.tekila.base.auth.persistence.exception;

/**
 * Created by sajabrayilov on 12/15/2014.
 */
public class NoPrivilegeFoundException extends Exception {
    private final static String defaultMessage = "Privilege not found";

    public NoPrivilegeFoundException() {
        super(defaultMessage);
    }

    public NoPrivilegeFoundException(String message) {
        super(defaultMessage + ": " + message);
    }

    public NoPrivilegeFoundException(String message, Throwable cause) {
        super(defaultMessage + ": " + message, cause);
    }

    public NoPrivilegeFoundException(Throwable cause) {
        super(cause);
    }

    public NoPrivilegeFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(defaultMessage + ": " + message, cause, enableSuppression, writableStackTrace);
    }
}
