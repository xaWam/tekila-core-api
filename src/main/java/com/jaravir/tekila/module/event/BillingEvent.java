package com.jaravir.tekila.module.event;

/**
 * Created by sajabrayilov on 12/1/2014.
 */
public enum BillingEvent {
    PAYMENT("PYMT"), INVOICE_CREATED("INV"), SUBSCRIPTION_ADDED("SUB_ADD"),
    VAS_ADDED("VAS_ADD"), PASSWORD_CHANGE("PASS"), STATUS_CHANGED("STATUS"),
    SUBSCRIPTION_SOON_EXPIRES("SUB_SOON_EXP"), SOON_PARTIAL_BLOCKED("SOON_PART_BLOCK"),
    SOON_BLOCKED_GRACE("SOON_BLOCK_GRACE"), CITYNET_SERVICE_CHANGE("CITYNET_SERVICE_CHANGE"),
    SOON_BLOCKED_CONTINUOUS("SOON_BLOCK_CONT")
    ;

    private final String code;

    BillingEvent (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static BillingEvent convertFromCode(String code) {
        for (BillingEvent event : values())
            if (event.getCode().equals(code))
                return event;

        return null;
    }
}
