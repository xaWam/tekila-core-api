package com.jaravir.tekila.module.periodic;

/**
 * Created by sajabrayilov on 5/4/2015.
 */
public enum JobPropertyType {
    CATEGORY("CAT"),
    TARGET("TARGET"),
    INITIAL_STATUS("INIT_STATUS"),
    FINAL_STATUS("FIN_STATUS"),
    VAS_ID("VAS_ID"),
    VAS_EXPIRATION_DATE("VAS_EXPIRATION_DATE"),
    SUBSCRIPTION_SERVICE_ID("SBN_SERVICE_ID"),
    CAMPAIGN_ID("CAMPAIGN_ID"),
    PAYMENT_ID("PAYMENT_ID"),
    IP_ADDRESS_STR("IP_ADDRESS_STR"),
    VAS_COUNT("VAS_COUNT");
    private final String code;

    JobPropertyType (String code) {
        this.code = code;
    }

    public String getCode () {
        return code;
    }

    public static JobPropertyType convertFromCode (String code) {
        if (code != null && !code.isEmpty()) {
            for (JobPropertyType type : values()) {
                if (type.code.equals(code))
                    return type;
            }
        }

        return null;
    }
}
