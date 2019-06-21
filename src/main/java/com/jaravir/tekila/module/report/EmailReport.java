package com.jaravir.tekila.module.report;

import com.jaravir.tekila.base.entity.BaseEntity;
import org.joda.time.DateTime;

/**
 * Created by kmaharov on 25.01.2017.
 */
public class EmailReport extends BaseEntity {
    private DateTime fromDate;
    private DateTime toDate;
    private String email;
    private boolean sent;
    private String selectedProviderId;
    private String externalUserName;

    public EmailReport() {
    }

    public DateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(DateTime fromDate) {
        this.fromDate = fromDate;
    }

    public DateTime getToDate() {
        return toDate;
    }

    public void setToDate(DateTime toDate) {
        this.toDate = toDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public String getSelectedProviderId() {
        return selectedProviderId;
    }

    public void setSelectedProviderId(String selectedProviderId) {
        this.selectedProviderId = selectedProviderId;
    }

    public String getExternalUserName() {
        return externalUserName;
    }

    public void setExternalUserName(String externalUserName) {
        this.externalUserName = externalUserName;
    }
}
