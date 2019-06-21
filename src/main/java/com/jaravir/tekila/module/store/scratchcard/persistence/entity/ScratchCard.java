/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaravir.tekila.module.store.scratchcard.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

import org.joda.time.DateTime;


/**
 * @created by shnovruzov on 26.04.2016
 */
public class ScratchCard extends BaseEntity implements Serializable {

    private long amount;
    private long batchID;
    private String pin;
    private DateTime validFrom;
    private DateTime validTo;
    private Serial serial;
    private int status;

    public Serial getSerial() {
        return serial;
    }

    public void setSerial(Serial serial) {
        this.serial = serial;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getBatchID() {
        return batchID;
    }

    public void setBatchID(long batchID) {
        this.batchID = batchID;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public DateTime getValidFrom() {
        return validFrom;
    }

    public Date getValidFromAsDate() {
        return validFrom == null ? null : validFrom.toDate();
    }

    public void setValidFrom(DateTime validFrom) {
        this.validFrom = validFrom;
    }

    public DateTime getValidTo() {
        return validTo;
    }

    public Date getValidToAsDate() {
        return validTo == null ? null : validTo.toDate();
    }

    public void setValidTo(DateTime validTo) {
        this.validTo = validTo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
