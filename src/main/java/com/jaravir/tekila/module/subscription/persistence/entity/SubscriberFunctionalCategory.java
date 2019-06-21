package com.jaravir.tekila.module.subscription.persistence.entity;

/**
 * Created by sajabrayilov on 25.02.2015.
 */
public enum SubscriberFunctionalCategory {
    COMMERCIAL ("COMM"),
    TEST ("TEST");

    private String code;

    SubscriberFunctionalCategory (String code) {
        this.code = code;
    }

    public static SubscriberFunctionalCategory convertFromCode(String code) {
        if (code != null) {
            for (SubscriberFunctionalCategory cat : values()) {
                if (cat.code.equals(code)) {
                    return cat;
                }
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }
}
