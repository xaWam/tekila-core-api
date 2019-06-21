package com.jaravir.tekila.base.auth;

/**
 * Created by sajabrayilov on 12/9/2014.
 */
public enum AccessMode {
    ALLOW(1), DENY(0);

    private final int code;

    AccessMode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AccessMode convertFromCode (int code) {
        for (AccessMode mode : values())
            if (mode.getCode() == code)
                return mode;

        return null;
    }
}
