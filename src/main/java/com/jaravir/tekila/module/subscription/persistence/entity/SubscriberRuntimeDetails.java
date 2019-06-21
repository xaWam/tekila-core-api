package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * Created by kmaharov on 27.01.2017.
 */
public class SubscriberRuntimeDetails extends BaseEntity implements Serializable {
    public static final String DEFAULT_SMS_CODE = "0";
    //for sending sms on service change
    private boolean smsSent;
    private int smsSentCount;
    private DateTime smsSentTime;
    private String smsCode;
    private int smsAttempt;
    private DateTime smsCodeExpiredTime;

    public SubscriberRuntimeDetails() {
        smsSent = false;
        smsCode = DEFAULT_SMS_CODE;
        smsSentCount = 0;
        smsAttempt = 0;
    }

    public boolean isSmsSent() {
        return smsSent;
    }

    public void setSmsSent(boolean smsSent) {
        this.smsSent = smsSent;
    }

    public int getSmsSentCount() {
        return smsSentCount;
    }

    public void setSmsSentCount(int smsSentCount) {
        this.smsSentCount = smsSentCount;
    }

    public DateTime getSmsSentTime() {
        return smsSentTime;
    }

    public void setSmsSentTime(DateTime smsSentTime) {
        this.smsSentTime = smsSentTime;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public int getSmsAttempt() {
        return smsAttempt;
    }

    public void setSmsAttempt(int smsAttempt) {
        this.smsAttempt = smsAttempt;
    }

    public DateTime getSmsCodeExpiredTime() {
        return smsCodeExpiredTime;
    }

    public void setSmsCodeExpiredTime(DateTime smsCodeExpiredTime) {
        this.smsCodeExpiredTime = smsCodeExpiredTime;
    }
}
