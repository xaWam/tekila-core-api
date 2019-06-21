package com.jaravir.tekila.provision.broadband.devices.exception;

/**
 * Created by sajabrayilov on 1/5/2015.
 */
public class PortAlreadyReservedException extends Exception {
    public PortAlreadyReservedException() {
    }

    public PortAlreadyReservedException(String message) {
        super(message);
    }

    public PortAlreadyReservedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PortAlreadyReservedException(Throwable cause) {
        super(cause);
    }

    public PortAlreadyReservedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
