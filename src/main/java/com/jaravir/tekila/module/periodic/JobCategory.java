package com.jaravir.tekila.module.periodic;

/**
 * Created by sajabrayilov on 5/4/2015.
 */
public enum JobCategory {
    SUBSCRIPTION_STATUS_CHANGE("SBN_STATUS_CHANGE"),
    SUBSCRIPTION_SERVICE_CHANGE("SBN_SERVICE_CHANGE"),
    SUBSCRIPTION_CAMPAIGN_ADD("SBN_CAMPAIGN_ADD"),
    SUBSCRIPTION_VAS_ADD("SBN_VAS_ADD");

    private final String code;

    JobCategory (String code) {
        this.code = code;
    }

    public String getCode () {
        return code;
    }

    public static JobCategory convertFromCode (String code) {
        if (code != null && !code.isEmpty()) {
            for (JobCategory type : values()) {
                if (type.code.equals(code))
                    return type;
            }
        }

        return null;
    }
}
