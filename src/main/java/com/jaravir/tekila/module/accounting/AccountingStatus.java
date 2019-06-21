package com.jaravir.tekila.module.accounting;

/**
 * Created by sajabrayilov on 6/19/2015.
 */
public enum AccountingStatus {
    REGULAR(0), VOID(-1);

    private final int status;

    AccountingStatus (int status) {
        this.status = status;
    }

    public static AccountingStatus convert (int searchedStatus) {
        for (AccountingStatus st : values()) {
            if (st.status == searchedStatus) {
                return st;
            }
        }

        return null;
    }

    public int getStatus () {
        return status;
    }
}
