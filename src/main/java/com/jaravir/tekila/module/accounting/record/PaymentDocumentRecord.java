/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaravir.tekila.module.accounting.record;

import java.io.Serializable;

/**
 *
 * @author sajabrayilov
 */
public class PaymentDocumentRecord implements Serializable {
    private Long bankID;
    private String agreement;
    private Long longAmount;
    private Double doubleAmount;

    public PaymentDocumentRecord() {}
    
    public PaymentDocumentRecord(Long bankID, String agreement, Double amount) {
        this.bankID = bankID;
        this.agreement = agreement;
        this.doubleAmount = amount;
        this.longAmount = Double.valueOf(amount * 100000).longValue();
    }
    
    public Long getBankID() {
        return bankID;
    }

    public void setBankID(Long bankID) {
        this.bankID = bankID;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public Long getLongAmount() {
        return longAmount;
    }

    public void setLongAmount(Long amount) {
        this.longAmount = amount;
    }

    public Double getDoubleAmount() {
        return doubleAmount;
    }

    public void setDoubleAmount(Double doubleAmount) {
        this.doubleAmount = doubleAmount;
    }

    public void setAmount (Double am) {
        this.doubleAmount = am;
        this.longAmount = Double.valueOf(am * 100000).longValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = 
            new StringBuilder("PaymentDocumentRecord{bankID=")
            .append(bankID)
            .append(", agreement=").append(agreement)
            .append(", amount=").append(longAmount)
            .append('}');
            return sb.toString();
    }
}
