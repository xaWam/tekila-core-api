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
public enum AccountingTransactionType {
    BATCH_ADJUSTMENT ("BATCH_ADJ"),
    BATCH_PAYMENT ("BATCH_PMT"),
    BATCH_PAYMENT_VAT ("BATCH_PMT_VAT"),
    ADJUSTMENT ("ADJ"),
    PAYMENT("PMT"),
    PAYMENT_TRANSFER ("PMT_TRANS"),
    BALANCE_TRANSFER("BLN_TRANS"),
    PROMO_ADJUSTMENT("PROMO_ADJ")
    ;
    
    private String code;
    
    private AccountingTransactionType (String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
    public static AccountingTransactionType getFromCode(String code) {
        if (code == null)
            return null;
        
        for (AccountingTransactionType type : values())
            if (type.code.equals(code))
                return type;
        
        return null;
    }
}
