package com.jaravir.tekila.module.convergent;

import com.jaravir.tekila.base.entity.BaseEntity;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * Created by khsadigov on 12/1/2016.
 */
public class ConvergentQueue extends BaseEntity implements Serializable {

    private String msisdn;
    private String event;
    private long service;
    private DateTime td;
    private int status;
    private String offer;
    private double price;
    private long service2;

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public long getService() {
        return service;
    }

    public void setService(long service) {
        this.service = service;
    }

    public long getService2() {
        return service2;
    }

    public void setService2(long service) {
        this.service2 = service;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DateTime getTd() {
        return td;
    }

    public void setTd(DateTime td) {
        this.td = td;
    }
}
