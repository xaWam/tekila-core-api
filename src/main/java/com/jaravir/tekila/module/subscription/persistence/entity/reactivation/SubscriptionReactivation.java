package com.jaravir.tekila.module.subscription.persistence.entity.reactivation;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.periodic.JobStatus;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;

/**
 * Created by sajabrayilov on 7/3/2015.
 */
public class SubscriptionReactivation extends BaseEntity {
    private DateTime createdDate;
    private ReactivationStatus status;
    private Subscription subscription;
    private DateTime reactivatedDate;

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ReactivationStatus getStatus() {
        return status;
    }

    public void setStatus(ReactivationStatus status) {
        this.status = status;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public DateTime getReactivatedDate() {
        return reactivatedDate;
    }

    public void setReactivatedDate(DateTime reactivatedDate) {
        this.reactivatedDate = reactivatedDate;
    }

    public String getReactivationAttemptDate() {
        String res = null;
        DateTimeFormatter df = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss");

        /*if (status == ReactivationStatus.SUCCESS && reactivatedDate != null) {
            res = reactivatedDate.toString(df);
        }
        else {
            res = createdDate.toString(df);
        }*/
        res = lastUpdateDate.toString(df);

        return res;
    }
}
