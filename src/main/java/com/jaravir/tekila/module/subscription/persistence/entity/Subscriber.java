package com.jaravir.tekila.module.subscription.persistence.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.jsonview.JsonViews;
import com.jaravir.tekila.module.accounting.entity.Invoice;
import com.jaravir.tekila.module.accounting.entity.TaxationCategory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

/**
 * Entity implementation class for Entity: SubscriberEntity
 *
 */
public class Subscriber extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6080783135933130187L;
    private Long master_account;
    private SubscriberDetails details;
    @JsonView(JsonViews.Subscriber.class)
    private List<Subscription> subscriptions;
    private boolean isBilledByLifeCycle;
    private SubscriberLifeCycleType lifeCycle;
    private DateTime lastPaymentDate;
    private Date creationDate;
    private List<Invoice> invoices;
    private TaxationCategory taxCategory;
    private SubscriberFunctionalCategory fnCategory;
    private SubscriberRuntimeDetails runtimeDetails;

    public Long getMasterAccount() {
        return master_account;
    }

    public void setMasterAccount(Long master_account) {
        this.master_account = master_account;
    }

    public SubscriberDetails getDetails() {
        return details;
    }

    public void setDetails(SubscriberDetails details) {
        this.details = details;
    }

    public List<Subscription> getSubscriptions() {
        if (subscriptions == null) {
            subscriptions = new ArrayList<>();
        }
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public boolean getBilledByLifeCycle() {
        return isBilledByLifeCycle;
    }

    public void setBilledByLifeCycle(boolean isBilledByLifeCycle) {
        this.isBilledByLifeCycle = isBilledByLifeCycle;
    }

    public SubscriberLifeCycleType getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(SubscriberLifeCycleType lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public DateTime getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(DateTime lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public Date getLastPaymentDateAsDate() {
        return (lastPaymentDate != null ? getLastPaymentDate().toDate() : null);
    }

    public void setLastPaymentDateAsDate(Date dt) {
        if (dt != null) {
            setLastPaymentDate(new DateTime(dt));
        }
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public TaxationCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxationCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    public SubscriberFunctionalCategory getFnCategory() {
        return fnCategory;
    }

    public void setFnCategory(SubscriberFunctionalCategory fnCategory) {
        this.fnCategory = fnCategory;
    }

    public SubscriberRuntimeDetails getRuntimeDetails() {
        return runtimeDetails;
    }

    public void setRuntimeDetails(SubscriberRuntimeDetails runtimeDetails) {
        this.runtimeDetails = runtimeDetails;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Subscriber{");
        sb.append(super.toString());
        sb.append(", master_account=").append(master_account);
        sb.append(", isBillByLyfeCycle=").append(isBilledByLifeCycle);
        sb.append(", lifeCycle=").append(lifeCycle);
        sb.append(", lastPayed=").append(lastPaymentDate != null ? lastPaymentDate : null);
        sb.append(", subscriptions=").append(subscriptions);
        sb.append(", details=").append(details);
        sb.append('}');
        return sb.toString();
    }
}
