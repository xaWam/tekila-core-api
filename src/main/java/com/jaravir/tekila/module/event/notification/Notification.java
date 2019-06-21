package com.jaravir.tekila.module.event.notification;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.base.entity.Language;
import com.jaravir.tekila.module.event.BillingEvent;
import com.jaravir.tekila.module.event.notification.channell.NotificationChannell;
import com.jaravir.tekila.module.service.entity.Service;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.module.subscription.persistence.entity.SubscriberLifeCycleType;
import com.jaravir.tekila.module.subscription.persistence.entity.SubscriberType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajabrayilov on 12/1/2014.
 */
public class Notification extends BaseEntity{
    private List<ServiceProvider> providerList;
    private BillingEvent event;
    private NotificationChannell channell;
    private String subject;
    private String notification;
    private Language lang;
    private SubscriberLifeCycleType lifeCycleType;
    private SubscriberType subscriberType;
    private List<Service> serviceList;

    public BillingEvent getEvent() {
        return event;
    }

    public void setEvent(BillingEvent event) {
        this.event = event;
    }

    public NotificationChannell getChannell() {
        return channell;
    }

    public void setChannell(NotificationChannell channell) {
        this.channell = channell;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Language getLanguage() {
        return lang;
    }

    public void setLanguage (Language lamg) {
        this.lang = lamg;
    }

    public SubscriberLifeCycleType getLifeCycleType() {
        return lifeCycleType;
    }

    public void setLifeCycleType(SubscriberLifeCycleType lifeCycleType) {
        this.lifeCycleType = lifeCycleType;
    }

    public SubscriberType getSubscriberType() {
        return subscriberType;
    }

    public void setSubscriberType(SubscriberType subscriberType) {
        this.subscriberType = subscriberType;
    }

    public List<ServiceProvider> getProviderList() {
        if (providerList == null)
            providerList = new ArrayList<>();
        return providerList;
    }

    public void setProviderList(List<ServiceProvider> provider) {
        this.providerList = provider;
    }

    public void addProvider(ServiceProvider provider) {
        if (provider != null)
            getProviderList().add(provider);
    }

    public List<Service> getServiceList() {
        if (serviceList == null)
            serviceList = new ArrayList<>();
        return serviceList;
    }

    public void setServiceList(List<Service> service) {
        this.serviceList = service;
    }

    public void addService (Service service) {
        if (service != null)
            getServiceList().add(service);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Notification{");
        sb.append(super.toString());
        sb.append(", provider=").append(providerList);
        sb.append(", service=").append(serviceList);
        sb.append(", subscriberType=").append(subscriberType);
        sb.append(", lifecycleType=").append(lifeCycleType);
        sb.append(", event=").append(event);
        sb.append(", channell=").append(channell);
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", notification='").append(notification).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
