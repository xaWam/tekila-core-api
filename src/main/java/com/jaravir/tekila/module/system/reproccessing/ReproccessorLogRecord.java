package com.jaravir.tekila.module.system.reproccessing;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.accounting.entity.Payment;
import com.jaravir.tekila.module.system.operation.OperationResult;

/**
 * Created by sajabrayilov on 24.01.2015.
 */
public class ReproccessorLogRecord extends BaseEntity{
    private Payment payment;
    private OperationResult result;
    private String dsc;

    public ReproccessorLogRecord () {}

    public ReproccessorLogRecord(Payment payment, OperationResult result, String dsc) {
        this.payment = payment;
        this.result = result;
        this.dsc = dsc;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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
}
