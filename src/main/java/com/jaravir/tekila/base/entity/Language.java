package com.jaravir.tekila.base.entity;

/**
 * Created by sajabrayilov on 12/2/2014.
 */
public enum Language {
    AZERI("AZE"), RUSSIAN("RUS"), ENGLISH("ENG");

    private String code;

    Language (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Language convertFromCode (String code) {
        for (Language lang : values())
            if (lang.getCode().equals(code))
                return lang;

        return null;
    }
}
