/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.accounting.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.jsonview.JsonViews;
import com.jaravir.tekila.module.accounting.AccountingStatus;
import com.jaravir.tekila.module.service.entity.Service;
import com.jaravir.tekila.module.service.entity.ValueAddedService;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscriber;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import org.joda.time.DateTime;

/**
 *
 * @author sajabrayilov
 */
public class Charge extends BaseEntity {
    @JsonView(JsonViews.Charge.class)
    private Service service;
    private long amount;
    private DateTime datetime;
    private String dsc;
    private User user;
    private Long user_id;
    @JsonView(JsonViews.Charge.class)
    private Subscriber subscriber;
    private ValueAddedService vas;
    @JsonView(JsonViews.Charge.class)
    private Subscription subscription;
    private AccountingStatus status;
    private Transaction transaction;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public DateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(DateTime datetime) {
        this.datetime = datetime;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }    

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
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
    
    public Date getDateTimeAsDate() {
        return this.datetime.toDate();
    }
    
    public void setDateTimeAsDate(Date dt) {
        this.datetime = new DateTime(dt);
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

    public AccountingStatus getStatus() {
        return status;
    }

    public void setStatus(AccountingStatus status) {
        this.status = status;
    }

    public int getStatusId() {
        return status != null ? status.getStatus() : 0;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Charge{");
        sb.append(super.toString());
        sb.append(", service=").append(service);
        sb.append(", vas=").append(vas);
        sb.append(", amount=").append(amount);
        sb.append(", datetime=").append(datetime != null ? datetime : null);
        sb.append(", dsc=").append(dsc);
        sb.append(", user=").append(user);
        sb.append(", user_id=").append(user_id);
        sb.append(", subscriberID=").append(subscriber.getId());
        sb.append(", subscription id=").append(subscription != null ? subscription.getId() : null);
        sb.append(", status=").append(status);
        return sb.append('}').toString();
    }
    
    
    
}
