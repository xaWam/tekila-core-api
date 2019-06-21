package com.jaravir.tekila.module.store.status;

/**
 * Created by sajabrayilov on 13.03.2015.
 */
public enum StoreItemStatus {
    AVAILABLE(0), RESERVED(1);

    private final int code;

    StoreItemStatus (int code) {
        this.code = code;
    }

    public int getCode () {
        return code;
    }

    public static StoreItemStatus getFromCode (int code) {
        for (StoreItemStatus st : values()) {
            if (st.code == code) {
                return st;
            }
        }
        return null;
    }
}
