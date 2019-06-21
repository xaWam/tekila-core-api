package com.jaravir.tekila.module.store.equip;

/**
 * Created by sajabrayilov on 11/14/2014.
 */
public enum EquipmentStatus {
    AVAILABLE(0), RESERVED(1), TRANSFERED(2);

    private final int code;

    EquipmentStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EquipmentStatus convertFromCode(int code) {
        for (EquipmentStatus status : values())
            if (status.code == code)
                return status;

        return null;
    }
}
