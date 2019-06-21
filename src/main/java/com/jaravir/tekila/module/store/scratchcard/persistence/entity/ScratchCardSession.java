package com.jaravir.tekila.module.store.scratchcard.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.accounting.entity.Payment;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by shnovruzov on 5/5/2016.
 */
public class ScratchCardSession extends BaseEntity implements Serializable {

    ScratchCard scratchCard;
    Subscription subscription;
    Payment payment;
    int wrongAttempt;
    boolean isBlocked;
    DateTime lastAttemptTime;
    String wrongPin;
    long wrongSerial;
    String agreement;
    Long serial;

    public Long getSerial() {
        return serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public ScratchCard getScratchCard() {
        return scratchCard;
    }

    public void setScratchCard(ScratchCard scratchCard) {
        this.scratchCard = scratchCard;
    }

    public Subscription getSubscription(){
        return subscription;
    }

    public void setSubscription(Subscription subscription){
        this.subscription = subscription;
    }

    public int getwrongAttempt(){
        return wrongAttempt;
    }

    public void setwrongAttempt(int wrongAttempt){
        this.wrongAttempt = wrongAttempt;
    }

    public DateTime getlastAttemptTime(){
        return lastAttemptTime;
    }

    public void setlastAttemptTime(DateTime lastAttemptTime){
        this.lastAttemptTime = lastAttemptTime;
    }

    public String getWrongPin(){
        return wrongPin;
    }

    public void setWrongPin(String wrongPin){
        this.wrongPin = wrongPin;
    }

    public long getWrongSerial(){
        return wrongSerial;
    }

    public void setWrongSerial(long wrongSerial){
        this.wrongSerial = wrongSerial;
    }

    public boolean getIsBlocked(){
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked){
        this.isBlocked = isBlocked;
    }

    public Date getLastUpdateDateAsDate(){
        return lastUpdateDate.toDate();
    }

}
