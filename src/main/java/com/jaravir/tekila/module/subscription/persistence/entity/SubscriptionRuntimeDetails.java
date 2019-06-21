package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * Created by kmaharov on 21.09.2016.
 */
public class SubscriptionRuntimeDetails extends BaseEntity implements Serializable {
    //password reset fields
    private int loginAttempt; //count of false login attempt since last succesfull login
    private String shaHash;
    private boolean expired;
    private DateTime passwordResetTime;
    //email registration field
    private String emailChecksum;
    private boolean emailActivated;
    //phone number fields
    private String phoneNumber;
    private DateTime phoneLastUpdateDate;
    //timestamp fields
    private DateTime firstVisitTime;
    private DateTime registrationTime;
    private DateTime lastLoginTime;

    public SubscriptionRuntimeDetails() {
        loginAttempt = 0;
    }

    public int getLoginAttempt() {
        return loginAttempt;
    }

    public void setLoginAttempt(int loginAttempt) {
        this.loginAttempt = loginAttempt;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public DateTime getPasswordResetTime() {
        return passwordResetTime;
    }

    public void setPasswordResetTime(DateTime passwordResetTime) {
        this.passwordResetTime = passwordResetTime;
    }

    public String getShaHash() {
        return shaHash;
    }

    public void setShaHash(String shaHash) {
        this.shaHash = shaHash;
    }

    public String getEmailChecksum() {
        return emailChecksum;
    }

    public void setEmailChecksum(String emailChecksum) {
        this.emailChecksum = emailChecksum;
    }

    public boolean isEmailActivated() {
        return emailActivated;
    }

    public void setEmailActivated(boolean emailActivated) {
        this.emailActivated = emailActivated;
    }

    public DateTime getPhoneLastUpdateDate() {
        return phoneLastUpdateDate;
    }

    public void setPhoneLastUpdateDate(DateTime phoneLastUpdateDate) {
        this.phoneLastUpdateDate = phoneLastUpdateDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public DateTime getFirstVisitTime() {
        return firstVisitTime;
    }

    public void setFirstVisitTime(DateTime firstVisitTime) {
        this.firstVisitTime = firstVisitTime;
    }

    public DateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(DateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public DateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(DateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
