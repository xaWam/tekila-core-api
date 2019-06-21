package com.jaravir.tekila.base.auth.persistence;

/**
 *
 * @author khsadigov
 */
public enum ExternalUserType {

    PAYMENT(1),
    GATEWAY(2),
    SUBSCRIBER(3);

    private final int code;

    private ExternalUserType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
