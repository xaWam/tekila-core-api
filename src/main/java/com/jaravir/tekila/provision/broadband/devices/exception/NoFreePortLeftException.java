package com.jaravir.tekila.provision.broadband.devices.exception;

/**
 * Created by sajabrayilov on 1/5/2015.
 */
public class NoFreePortLeftException extends Exception {
    public NoFreePortLeftException() {
    }

    public NoFreePortLeftException(String message) {
        super(message);
    }

    public NoFreePortLeftException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFreePortLeftException(Throwable cause) {
        super(cause);
    }

    public NoFreePortLeftException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
