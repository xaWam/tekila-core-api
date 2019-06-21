/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.subscription.persistence.entity;

/**
 * @author sajabrayilov
 */
public enum SubscriptionStatus {
    BLOCKED(99),
    PARTIALLY_BLOCKED(9),
    SUSPENDED(1),
    ACTIVE(0),
    INITIAL(6),
    FINAL(999),
    CANCEL(-1),
    PRE_FINAL(990);


    public final int STATUS;

    private SubscriptionStatus(int code) {
        this.STATUS = code;
    }

    public static SubscriptionStatus convertFromCode(int code) {
        for (SubscriptionStatus s : SubscriptionStatus.values())
            if (s.STATUS == code)
                return s;

        return null;
    }


}
