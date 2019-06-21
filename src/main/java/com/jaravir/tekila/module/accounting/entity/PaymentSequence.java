package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceProvider;

/**
 * Created by sajabrayilov on 12/23/2014.
 */
public class PaymentSequence extends BaseEntity {
    private long paymentNumber;

     public long getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(long agreementNumber) {
        this.paymentNumber = agreementNumber;
    }

    public synchronized long next() {
        return paymentNumber++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentSequence{");
        sb.append(super.toString());
        sb.append(", agreementNumber=").append(paymentNumber);
        sb.append('}');
        return sb.toString();
    }
}
