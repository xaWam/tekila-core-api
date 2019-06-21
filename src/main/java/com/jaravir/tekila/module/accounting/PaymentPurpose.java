package com.jaravir.tekila.module.accounting;

/**
 * Created by sajabrayilov on 11/18/2014.
 */
public enum PaymentPurpose {
    BALANCE("BLN"), VAT("VAT");

    private String code;

    PaymentPurpose (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static PaymentPurpose convertFromCode(String code) {
        for (PaymentPurpose purpose : values())
            if (purpose.getCode().equals(code))
                return purpose;

        return null;
    }
}
