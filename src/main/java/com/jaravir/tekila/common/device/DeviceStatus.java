package com.jaravir.tekila.common.device;

/**
 * Created by sajabrayilov on 1/6/2015.
 */
public enum DeviceStatus {
    INITIAL("INIT"),
    ACTIVE("ACT"),
    MAINTENANCE("MAINT"),
    WITHDRAWN("WITHD"),
    PRODUCTION("PROD");

    private final String code;

    DeviceStatus (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static DeviceStatus convertFromCode (String code) {
        for (DeviceStatus status : values())
            if (status.code.equals(code))
                return status;

        return null;
    }
}
