package com.jaravir.tekila.module.store.mobile;

/**
 * Created by sajabrayilov on 13.03.2015.
 */
public enum MobileCategory {
    COMMERCIAL("COM", 2), INITIAL("INIT", 1), TEST("TEST", 3);

    private String code;
    private Integer position;

    MobileCategory (String code, Integer position) {
        this.code = code;
        this.position = position;
    }

    public String getCode() {
        return code;
    }

    public int getPosition() {
        return position;
    }

    public static MobileCategory getFromCode(String code) {
        if (code == null)
            throw new IllegalArgumentException("Code argument cannot be null");

        for (MobileCategory cat : values())
            if (cat.code.equals(code))
                return cat;

        return null;
    }

    public static MobileCategory getFromPosition (Integer position) {
        if (position == null)
            throw new IllegalArgumentException("Position argument cannot be null");

        for (MobileCategory cat : values())
            if (cat.position.equals(position))
                return cat;

        return null;
    }
}
