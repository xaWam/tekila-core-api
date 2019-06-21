package com.jaravir.tekila.module.service.model;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * Created by sajabrayilov on 6/19/2015.
 */
public class BillingModel extends BaseEntity {
    private BillingPrinciple principle;
    private boolean applyLateFee;
    private String name;
    private String dsc;
    private int gracePeriodInDays;

    public BillingPrinciple getPrinciple() {
        return principle;
    }

    public void setPrinciple(BillingPrinciple principle) {
        this.principle = principle;
    }

    public boolean isApplyLateFee() {
        return applyLateFee;
    }

    public void setApplyLateFee(boolean applyLateFee) {
        this.applyLateFee = applyLateFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public int getGracePeriodInDays() {
        return gracePeriodInDays;
    }

    public void setGracePeriodInDays(int gracePeriodInDays) {
        this.gracePeriodInDays = gracePeriodInDays;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BiillingModel{");
        sb.append(super.toString());
        sb.append(", name").append(name);
        sb.append(", principle=").append(principle);
        sb.append(", applyLateFee=").append(applyLateFee);
        sb.append(", gracePeriodInDays=").append(gracePeriodInDays);
        sb.append('}');
        return sb.toString();
    }
}
