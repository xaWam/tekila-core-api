package com.jaravir.tekila.module.subscription.persistence.entity.agreement;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.module.subscription.persistence.entity.SubscriberFunctionalCategory;

/**
 * Created by sajabrayilov on 12/23/2014.
 */
public class AgreementSequence extends BaseEntity {
    private ServiceProvider provider;
    private long agreementNumber;

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public long getAgreementNumber() {
        return agreementNumber;
    }

    public void setAgreementNumber(long agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    public synchronized long next() {
        return agreementNumber++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AgreementSequence{");
        sb.append(super.toString());
        sb.append(", provider=").append(provider);
        sb.append(", agreementNumber=").append(agreementNumber);
        sb.append('}');
        return sb.toString();
    }
}
