/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.accounting;

/**
 *
 * @author sajabrayilov
 */
public enum PaymentMethod {
    CASH(10), BANK(11), SCRATCHCARD(12);
    
    private final int code;
    
    private PaymentMethod(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public static PaymentMethod getMethodFromCode (int code) {
        for (PaymentMethod method : PaymentMethod.values()) {
            if (method.getCode() == code)
                return method;
        }
        return null;
    }
}
