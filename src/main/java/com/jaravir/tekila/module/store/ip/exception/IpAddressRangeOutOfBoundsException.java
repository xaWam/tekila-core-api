package com.jaravir.tekila.module.store.ip.exception;

/**
 * Created by sajabrayilov on 11/25/2014.
 */
public class IpAddressRangeOutOfBoundsException extends IndexOutOfBoundsException {
    private final static String message = "IP address range is out of bounds";

    public IpAddressRangeOutOfBoundsException() {
        this(message);
    }

    public IpAddressRangeOutOfBoundsException(String s) {
        super(new StringBuilder(s).append(": ").append(message).toString());
    }
}
