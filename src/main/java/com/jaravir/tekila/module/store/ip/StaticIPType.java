package com.jaravir.tekila.module.store.ip;

/**
 * Created by shnovruzov on 10/26/2016.
 */
public enum StaticIPType {
    NORMAL_CHARGED(1),
    COMMANDANT_FREE(2);

    private int code;

    StaticIPType(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static StaticIPType convertFromCode(int code) {
        for (StaticIPType status : values())
            if (status.code == code)
                return status;

        return null;
    }
}
