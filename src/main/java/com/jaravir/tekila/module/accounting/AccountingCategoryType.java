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
    
public enum AccountingCategoryType {
    REALIZATION ("REALZN"),
    LATE_FEE ("LTFEE"),
    DEBT_WRITEOFF ("DBTWROFF"),
    SPECIAL ("SPECIAL"),
    PAYMENT_ADJUSTMENT ("PMTADJ"),
    BALANCE_WRITEOFF ("BALWROFF"),
    DISCOUNT ("DISCNT"),
    BALANCE_REFUND ("BALRFND"),
    BALANCE_TRANSFER("BALTRANS"),
    PAYMENT("PMT"),
    MODEM("MDM"),
    SERVIS("SRVS"),
    BERPA("BRP");



    private final String code;
    
    AccountingCategoryType (String code) {
        this.code = code;
    }
    
    public String getCode () {
        return this.code;
    }
    
    public static AccountingCategoryType getFromCode (String extCode) {
        if (extCode == null)
            return null;
        
        for (AccountingCategoryType type : AccountingCategoryType.values()) 
            if (type.code.equals(extCode))
                return type;
        
        return null;
    }
}
