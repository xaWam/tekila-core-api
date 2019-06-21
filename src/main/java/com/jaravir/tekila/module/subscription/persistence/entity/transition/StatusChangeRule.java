package com.jaravir.tekila.module.subscription.persistence.entity.transition;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ValueAddedService;
import com.jaravir.tekila.module.subscription.persistence.entity.SubscriptionStatus;

/**
 * Created by sajabrayilov on 4/29/2015.
 */
public class StatusChangeRule extends BaseEntity {
    private SubscriptionStatus initialStatus;
    private SubscriptionStatus finalStatus;
    private ValueAddedService vas;

    public StatusChangeRule() {
    }

    public StatusChangeRule(SubscriptionStatus initialStatus, SubscriptionStatus finalStatus) {
        this.initialStatus = initialStatus;
        this.finalStatus = finalStatus;
    }

    public StatusChangeRule(SubscriptionStatus initialStatus, SubscriptionStatus finalStatus, ValueAddedService vas) {
        this.initialStatus = initialStatus;
        this.finalStatus = finalStatus;
        this.vas = vas;
    }

    public ValueAddedService getVas() {
        return vas;
    }

    public void setVas(ValueAddedService vas) {
        this.vas = vas;
    }

    public SubscriptionStatus getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(SubscriptionStatus finalStatus) {
        this.finalStatus = finalStatus;
    }

    public SubscriptionStatus getInitialStatus() {
        return initialStatus;
    }

    public void setInitialStatus(SubscriptionStatus initialStatus) {
        this.initialStatus = initialStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusChangeRule that = (StatusChangeRule) o;

        if (finalStatus != that.finalStatus) return false;
        if (initialStatus != that.initialStatus) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = initialStatus != null ? initialStatus.hashCode() : 0;
        result = 31 * result + (finalStatus != null ? finalStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StatusChangeRule{");
        sb.append(super.toString());
        sb.append(", initialStatus=").append(initialStatus);
        sb.append(", finalStatus=").append(finalStatus);
        sb.append(", vas id=").append(vas.getId());
        sb.append('}');
        return sb.toString();
    }
}
