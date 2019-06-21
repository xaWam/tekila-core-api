package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.accounting.AccountingStatus;
import com.jaravir.tekila.module.sales.persistence.entity.SalesPartner;
import com.jaravir.tekila.module.service.entity.Service;
import com.jaravir.tekila.module.service.entity.ValueAddedService;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscriber;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;
import org.joda.time.DateTime;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Created by sajabrayilov on 11/30/2015.
 */
public class SalesPartnerCharge extends BaseEntity {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    //private Subscription subscription;
    private long amount;
    private String dsc;
    private User user;
    private SalesPartner salesPartner;
    private AccountingStatus status;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAmountForView() {
        double interm = amount / 100000d;
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);
        //return Long.valueOf(interm).doubleValue();
        return String.format("%.2f", interm);
    }

    public void setAmountForView (double am) {

    }

    public AccountingStatus getStatus() {
        return status;
    }

    public void setStatus(AccountingStatus status) {
        this.status = status;
    }

    public SalesPartner getSalesPartner() {
        return salesPartner;
    }

    public void setSalesPartner(SalesPartner salesPartner) {
        this.salesPartner = salesPartner;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Charge{");
        sb.append(super.toString());
        sb.append(", amount=").append(amount);
        sb.append(", dsc=").append(dsc);
        sb.append(", user=").append(user);
        sb.append(", status=").append(status);
        return sb.append('}').toString();
    }
}


