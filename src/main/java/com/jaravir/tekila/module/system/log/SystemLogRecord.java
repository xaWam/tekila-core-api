package com.jaravir.tekila.module.system.log;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.accounting.entity.Transaction;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;
import com.jaravir.tekila.module.system.SystemEvent;
import com.jaravir.tekila.module.system.operation.OperationResult;

/**
 * Created by sajabrayilov on 06.02.2015.
 */
public class SystemLogRecord extends BaseEntity {
    private SystemEvent event;
    private String agreement;
    private ServiceProvider provider;
    private Subscription subscription;
    private User user;
    private Transaction transaction;
    private OperationResult result;
    private String dsc;

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OperationResult getResult() {
        return result;
    }

    public void setResult(OperationResult result) {
        this.result = result;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public SystemEvent getEvent() {
        return event;
    }

    public void setEvent(SystemEvent event) {
        this.event = event;
    }
}
