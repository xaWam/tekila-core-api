package com.jaravir.tekila.module.accounting;

/**
 * Created by sajabrayilov on 12/30/2014.
 */
public enum FinancialType {
    PAYMENT ("PMT"),
    ADJUSTMENT ("ADJ");

    private final String code;

    FinancialType (String code) {
        this.code = code;
    }

    public String getCode () {
        return this.code;
    }

    public static FinancialType convertFromCode(String code) {
        if (code == null || code.isEmpty())
            return null;

        for (FinancialType type : values())
            if (type.getCode().equals(code))
                return type;

        return null;
    }
}
