/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaravir.tekila.base.entity;

/**
 * @author sajabrayilov
 */
public class BillingSettings extends BaseEntity {
    private int prepaidlifeCycleLength;
    private int pospaidLifeCycleLength;
    private int maximumPrepaidlifeCycleLength;
    private int prepaidNumDaysToBillBeforeExpiration;
    private int prepaidNumDaysToBillAfterExpiration;
    private int postpaidDefaultGracePeriod;
    private int prepaidMaximumCredit;
    private int postpaidMaximumCredit;
    private int rateFactor;
    private int maximumLoginRetryCount;
    private int userBlockPeriodInHours;
    private int beforeCancelPeriodInDays;
    private int passwordChangeInterval;
    private int userMaxIdleDays ;

    public BillingSettings() {
        prepaidlifeCycleLength = 30;
        pospaidLifeCycleLength = 30;
        maximumPrepaidlifeCycleLength = 31;
        postpaidDefaultGracePeriod = 30;
        prepaidNumDaysToBillBeforeExpiration = 1;
        prepaidNumDaysToBillAfterExpiration = 5;
        postpaidDefaultGracePeriod = 15;
        prepaidMaximumCredit = 0;
        postpaidMaximumCredit = 0;
        rateFactor = 100000;
        maximumLoginRetryCount = 5;
        userBlockPeriodInHours = 24;
        beforeCancelPeriodInDays = 14;
        passwordChangeInterval = 90;
        userMaxIdleDays = 45;
    }


    public int getUserMaxIdleDays() {
        return userMaxIdleDays;
    }

    public void setUserMaxIdleDays(int userMaxIdleDays) {
        this.userMaxIdleDays = userMaxIdleDays;
    }

    public int getPasswordChangeInterval() {
        return passwordChangeInterval;
    }

    public void setPasswordChangeInterval(int passwordChangeInterval) {
        this.passwordChangeInterval = passwordChangeInterval;
    }

    public int getPrepaidNumDaysToBillAfterExpiration() {
        return prepaidNumDaysToBillAfterExpiration;
    }

    public void setPrepaidNumDaysToBillAfterExpiration(int prepaidNumDaysToBillAfterExpiration) {
        this.prepaidNumDaysToBillAfterExpiration = prepaidNumDaysToBillAfterExpiration;
    }

    public int getBeforeCancelPeriodInDays() {
        return beforeCancelPeriodInDays;
    }

    public void setBeforeCancelPeriodInDays(int beforeCancelPeriodInDays) {
        this.beforeCancelPeriodInDays = beforeCancelPeriodInDays;
    }

    public int getPrepaidlifeCycleLength() {
        return prepaidlifeCycleLength;
    }

    public void setPrepaidlifeCycleLength(int prepaidlifeCycleLength) {
        this.prepaidlifeCycleLength = prepaidlifeCycleLength;
    }

    public int getPrepaidNumDaysToBillBeforeExpiration() {
        return prepaidNumDaysToBillBeforeExpiration;
    }

    public void setPrepaidNumDaysToBillBeforeExpiration(int prepaidNumDaysToBillBeforeExpiration) {
        this.prepaidNumDaysToBillBeforeExpiration = prepaidNumDaysToBillBeforeExpiration;
    }

    public int getPostpaidDefaultGracePeriod() {
        return postpaidDefaultGracePeriod;
    }

    public void setPostpaidDefaultGracePeriod(int postpaidDefaultGracePeriod) {
        this.postpaidDefaultGracePeriod = postpaidDefaultGracePeriod;
    }

    public int getPospaidLifeCycleLength() {
        return pospaidLifeCycleLength;
    }

    public void setPospaidLifeCycleLength(int pospaidLifeCycleLength) {
        this.pospaidLifeCycleLength = pospaidLifeCycleLength;
    }

    public int getMaximumPrepaidlifeCycleLength() {
        return maximumPrepaidlifeCycleLength;
    }

    public void setMaximumPrepaidlifeCycleLength(int maximumPrepaidlifeCycleLength) {
        this.maximumPrepaidlifeCycleLength = maximumPrepaidlifeCycleLength;
    }

    public int getPrepaidMaximumCredit() {
        return prepaidMaximumCredit;
    }

    public void setPrepaidMaximumCredit(int prepaidMaximumCredit) {
        this.prepaidMaximumCredit = prepaidMaximumCredit;
    }

    public int getPostpaidMaximumCredit() {
        return postpaidMaximumCredit;
    }

    public void setPostpaidMaximumCredit(int postpaidMaximumCredit) {
        this.postpaidMaximumCredit = postpaidMaximumCredit;
    }

    public int getRateFactor() {
        return rateFactor;
    }

    public void setRateFactor(int rateFactor) {
        this.rateFactor = rateFactor;
    }

    public int getMaximumLoginRetryCount() {
        return maximumLoginRetryCount;
    }

    public void setMaximumLoginRetryCount(int maximumLoginRetryCount) {
        this.maximumLoginRetryCount = maximumLoginRetryCount;
    }

    public int getUserBlockPeriodInHours() {
        return userBlockPeriodInHours;
    }

    public void setUserBlockPeriodInHours(int userBlockPeriodInHours) {
        this.userBlockPeriodInHours = userBlockPeriodInHours;
    }
}
