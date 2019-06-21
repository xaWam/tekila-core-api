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
public enum InvoiceState {
    CLOSED(0), OPEN(1);
    
    private final int state;

    private InvoiceState(int state) {
        this.state = state;
    }
    
    public int getState() {
        return state;
    }
    
    public static InvoiceState getFromState(int stateCode) {
        for (InvoiceState st : values()) {
            if (st.getState() == stateCode)
                return st;
        }
        return null;
    }
}
