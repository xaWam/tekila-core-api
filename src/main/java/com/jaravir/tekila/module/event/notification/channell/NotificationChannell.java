package com.jaravir.tekila.module.event.notification.channell;

/**
 * Created by sajabrayilov on 12/1/2014.
 */
public enum NotificationChannell {
    EMAIL("email"), SMS("SMS"), SCREEN("screen");

    private final String code;

    NotificationChannell (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static NotificationChannell convertFromCode(String code) {
        for (NotificationChannell channell : values())
            if (channell.getCode().equals(code))
                return channell;

        return null;
    }
}
