/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ValueAddedService;
import org.joda.time.DateTime;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sgulmammadov
 */
public class SubscriptionVAS extends BaseEntity {
    private ValueAddedService vas;
    private Subscription subscription;
    private List<SubscriptionVASSetting> settings;
    private SubscriptionResource resource;
    private DateTime billedUpToDate;
    private DateTime expirationDate;
    private SubscriptionStatus status;
    private long price;
    private DateTime activeFromDate;
    private long serviceFeeRate;
    private double count;
    private Double remainCount;
    private String desc;
    private int  vasStatus;

    public int getVasStatus() {
        return vasStatus;
    }

    public void setVasStatus(int vasStatus) {
        this.vasStatus = vasStatus;
    }

    public Double getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Double remainCount) {
        this.remainCount = remainCount;
    }

    public ValueAddedService getVas() {
        return vas;
    }

    public void setVas(ValueAddedService vas) {
        this.vas = vas;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public SubscriptionResource getResource() {
        return resource;
    }

    public void setResource(SubscriptionResource resource) {
        this.resource = resource;
    }

    public DateTime getBilledUpToDate() {
        return billedUpToDate;
    }

    public void setBilledUpToDate(DateTime billedUpToDate) {
        this.billedUpToDate = billedUpToDate;
    }

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

   /*
   *  public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
   * */

    public List<SubscriptionVASSetting> getSettings() {
        if (settings == null)
            settings = new ArrayList<>();
        return settings;
    }

    public void addSetting(String name, String value, String dsc) {
        addSetting(new SubscriptionVASSetting(name, value, dsc));
    }

    public void addSetting(String name, String value, String length, String dsc) {
        addSetting(new SubscriptionVASSetting(name, value, length, dsc));
    }

    public void addSetting(SubscriptionVASSetting setting) {
        getSettings().add(setting);
    }

    public void setSettings(List<SubscriptionVASSetting> settings) {
        this.settings = settings;
    }

    public void removeSetting(SubscriptionVASSetting setting) {
        if (getSettings().contains(setting))
            getSettings().remove(setting);
    }

    public SubscriptionVASSetting getSettingByName(String name) {
        if (settings != null && !settings.isEmpty()) {
            for (SubscriptionVASSetting set : settings) {
                if (set.getName().equals(name)) {
                    return set;
                }
            }
        }

        return null;
    }

    public String getTotal() {
        long total = 0;

        if (settings != null && !settings.isEmpty()) {
            for (SubscriptionVASSetting set : settings) {
                total += set.getTotal();
            }
        }

        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);
        return String.format("%.2f", total / 100000d);
    }

    public DateTime getActiveFromDate() {
        return activeFromDate;
    }

    public void setActiveFromDate(DateTime activeFromDate) {
        this.activeFromDate = activeFromDate;
    }

    public Date getActiveFromDateAsDate() {
        return activeFromDate != null ? activeFromDate.toDate() : null;
    }

    public Date getExpirationDateAsDate() {
        return expirationDate != null ? expirationDate.toDate() : null;
    }


    public long getServiceFeeRate() {
        return serviceFeeRate;
    }

    public void setServiceFeeRate(long serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate;
    }


    public void setServiceFeeRate(double serviceFeeRate) {
        this.serviceFeeRate = Double.valueOf(serviceFeeRate).longValue();
    }


    public double getCount() {
        if (count < 1) {
            return 1;
        }
        return count;
    }

    public void setCount(double count) { this.count = count; }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getServiceFeeForView() {
        double interm = serviceFeeRate / 100000d;
        //return Long.valueOf(interm).doubleValue();
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);
        return String.format("%.2f", interm);
    }

    public void setServiceFeeForView(String serviceFeeRate) {
        this.serviceFeeRate = Double.valueOf(Double.parseDouble(serviceFeeRate) * 100000.0D).longValue();
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
