package com.jaravir.tekila.module.sales;

/**
 * Created by sajabrayilov on 11/24/2015.
 */
public enum SalesPartnerType {
    DISTRIBUTOR("Distributor", "DIST"), DEALER("Dealer","DEAL");

    private final String value;
    private final String code;

    SalesPartnerType (String value, String code) {
        this.value = value;
        this.code = code;
    }

    public String getValue () {
        return value;
    }

    public String getCode () {
        return code;
    }

    public static SalesPartnerType convertFromCode (final String code) {
        for (SalesPartnerType salesPartnerType : values()) {
            if (salesPartnerType.getCode().equals(code)) {
                return salesPartnerType;
            }
        }

        return null;
    }
}
