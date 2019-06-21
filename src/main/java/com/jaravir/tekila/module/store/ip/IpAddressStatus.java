package com.jaravir.tekila.module.store.ip;

/**
 * Created by sajabrayilov on 11/14/2014.
 */
public enum IpAddressStatus {
    AVAILABLE(0), RESERVED(1);

    private final int code;

    IpAddressStatus (int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static IpAddressStatus convertFromCode(int code) {
        for (IpAddressStatus status : values())
            if (status.code == code)
                return status;

        return null;
    }
}
