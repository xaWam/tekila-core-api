package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

import java.sql.Date;

/**
 * Created by kmaharov on 22.06.2016.
 */

public class Compensation extends BaseEntity {
    Date fromDate;
    Integer dayCount;
    String ticketId;
    String comments;
    Subscription subscription;

    public Compensation() {

    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
