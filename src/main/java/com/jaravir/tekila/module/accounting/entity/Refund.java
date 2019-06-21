/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.Service;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscriber;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;
import java.util.Date;
import org.joda.time.DateTime;

/**
 *
 * @author sajabrayilov
 */
public class Refund extends BaseEntity {
    //private Subscription subscription;
    private Service service;
    private long amount;
    private DateTime datetime;
    private String dsc;
    private User user;
    private Long user_id;    
    private Subscriber subscriber;
    private String chequeID;
        
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
    
    public double getAmountForView() {
        return amount / 100000D;
    }
    
    public void setAmountForView (double am) {}
    
    public Date getDateTimeAsDate() {
        return this.datetime.toDate();
    }
    
    public void setDateTimeAsDate(Date dt) {
        this.datetime = new DateTime(dt);
    }

    public String getChequeID() {
        return chequeID;
    }

    public void setChequeID(String chequeID) {
        this.chequeID = chequeID;
    }
    
    
    @Override
    public String toString() {
        return "Refund{" + "service=" + service + ", amount=" + amount + ", datetime=" + datetime + ", dsc=" + dsc + ", user=" + user + ", user_id=" + user_id + ", clientID=" + subscriber.getId()+ ", " + super.toString() + '}';
    }
    
    
    
}
