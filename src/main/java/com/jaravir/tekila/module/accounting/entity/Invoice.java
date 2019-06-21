/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.accounting.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.jsonview.JsonViews;
import com.jaravir.tekila.module.accounting.AccountingStatus;
import com.jaravir.tekila.module.accounting.InvoiceState;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscriber;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;
import org.joda.time.DateTime;

/**
 *
 * @author sajabrayilov
 */
public class Invoice extends BaseEntity implements Serializable {
    private InvoiceState state;
    private Long sumPaid;
    private Long sumCharged;
    private Long balance;
    private Date creationDate;
    private DateTime closeDate;
    private DateTime lastChargeDate;
    private DateTime lastPaymentDate;
    @JsonView(JsonViews.Invoice.class)
    private Subscriber subscriber;
    private List<Charge> charges;
    private List<Payment> payments;
    private List<Refund> refunds;
    private Subscription subscription;
    private User user;
    private AccountingStatus status;

    public Invoice() {
        sumPaid = 0L;
        sumCharged = 0L;
        balance = 0L;

        charges = new ArrayList<Charge>();
        payments = new ArrayList<Payment>();
        refunds = new ArrayList<Refund>();                
    }
    
    public InvoiceState getState() {
        return state;
    }

    public void setState(InvoiceState state) {
        this.state = state;
    }

    public Long getSumPaid() {
        return sumPaid;
    }

    public void setSumPaid(Long sumPaid) {
        this.sumPaid = sumPaid;
    }

    public Long getSumCharged() {
        return sumCharged;
    }

    public void setSumCharged(Long sumCharged) {
        this.sumCharged = sumCharged;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
    
    public String getBalanceForView() {
        if (balance == null) return "0";
        
        double interm = balance / 100000d;
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);
        //return Long.valueOf(interm).doubleValue();
        return String.format("%.2f", interm);
    }
    
    public String getSumChargedForView() {
        if (sumCharged == null) return "0";
        
        double interm = sumCharged / 100000d;
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);

        //return Long.valueOf(interm).doubleValue();
        return String.format("%.2f", interm);
    }
    
    public String getSumPaidForView() {
        if (sumPaid == null) return "0";
        
        double interm = sumPaid / 100000d;
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);

        //return Long.valueOf(interm).doubleValue();
        return String.format("%.2f", interm);
 
    }
    
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public DateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(DateTime closeDate) {
        this.closeDate = closeDate;
    }

    public Date getCloseDateAsDate() {
        return (closeDate != null ? closeDate.toDate() : null);
    }
    
    public void setCloseDateAsDate(Date dt) {
        if (dt != null)
            closeDate = new DateTime(dt);
    }
    
    public Subscriber getSubscriber() {
        return subscriber;
    }

    public DateTime getLastChargeDate() {
        return lastChargeDate;
    }

    public void setLastChargeDate(DateTime lastChargeDate) {
        this.lastChargeDate = lastChargeDate;
    }

    public DateTime getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(DateTime lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Refund> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<Refund> refunds) {
        this.refunds = refunds;
    }

    
    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }   
    
    public void addChargeToList(Charge charge) {
        this.charges.add(charge);
        this.addDebt(charge.getAmount());
    }

    public void addChargesToListWithCheck (Charge charge, long startBalance, long endBalance, long totalCharged) {
        this.addChargeToList(charge);
        this.calculateRealBalance(startBalance, endBalance, totalCharged);
    }
    
    public void addChargeToList(Charge charge, boolean isDoAddToDebt) {
        this.charges.add(charge);
        if (isDoAddToDebt) {
            this.addDebt(charge.getAmount());
        }
    }
        
    public long addPaymentToList(Payment payment, long residualValue) {
        this.payments.add(payment);
        Float sum = payment.getAmount().floatValue() * 100000;
        return this.addPayment(residualValue > 0 ? residualValue : sum.longValue());
    }
    
    public void addDebt(long debt) {        
        if (this.sumCharged == null)
            sumCharged = 0L;
        if (balance == null)
            balance = 0L;
        
        this.sumCharged += debt;
        this.balance -= debt;
        this.lastChargeDate = DateTime.now();
    }
    
    public void reduceDebt (long debt) {
        if (this.sumCharged == null)
            sumCharged = 0L;
        if (balance == null)
            balance = 0L;
        if (sumPaid == null)
            sumPaid = 0L;
        
        if (balance < 0) {
            this.balance += debt;
            this.sumPaid += debt;            
        }
        this.lastChargeDate = DateTime.now();
    }
    
    public long addPayment(long payment) {
        if (sumPaid == null)
            sumPaid = 0L;
        if (balance == null)
            balance = 0L;
        
        long modulusBalance = Math.abs(balance);
        long residualBalance = 0;
        
        if (payment > modulusBalance) {
            residualBalance = payment - modulusBalance;
            payment = modulusBalance;
        }
        
        this.sumPaid += payment;
        this.balance += payment;
        this.lastPaymentDate = DateTime.now();
        
        if (this.balance >= 0) {
            this.state = InvoiceState.CLOSED;
            this.setCloseDate(DateTime.now());
        }
        
        return residualBalance;
    }
    
    public void calculateRealBalance(long startBalance, long endBalance, long totalCharged) {
        if (startBalance >= 0 && endBalance < 0) {
           reduceDebt(startBalance);
        }
        else if (endBalance >= 0) {
            reduceDebt(totalCharged);
        }
    }
    
    public void close() {
        if (getBalance() >=0) {
            setState(InvoiceState.CLOSED);
            setCloseDate(DateTime.now());
        }
    }

    public void tryClose(long startBalance, long endBalance, long totalCharged) {
        calculateRealBalance(startBalance, endBalance, totalCharged);
        close();
    }

    public long cancelPaymentWithResidual (Payment payment) {
        Payment lastPayment = getLastPayment();
        long sum = sumCharged;
        long residual = 0;

        if (lastPayment != null && lastPayment.getId() == payment.getId()) { //our payment is the last on invoice
            Payment pmt = null;
            for (int i = 0; i < payments.size() - 1; i++) { //subtract other payments from sumCharged
                pmt = payments.get(i);

                if (pmt.getStatus() == -1) //skip void payments
                    continue;

                sum -= pmt.getAmountAsLong();
            }

            if (sum == payment.getAmountAsLong()) { //if our payment fully settled on invoice cancel it
                cancelPayment(payment.getAmountAsLong());
            }
            else  { //subtract the payment used to close the invoice
                residual = payment.getAmountAsLong() - sum;
            }
        }
        else { // if our payment not the last just cancel it
            cancelPayment(payment.getAmountAsLong());
        }

        return residual;
    }

    public Payment getLastPayment() {
        Payment payment = null;
        if (payments != null && !payments.isEmpty()) {
            payment = payments.get(payments.size() - 1);
            if (payment.getStatus() != -1) // make sure last payment is not void
                return payment;
        }
        return null;
    }

    public void cancelPayment (long amount) {
        if (this.sumCharged == null)
            sumCharged = 0L;
        if (balance == null)
            balance = 0L;
        if (sumPaid == null)
            sumPaid = 0L;

        if (sumPaid >= amount)
            sumPaid -= amount;

        balance -= amount;

        if (balance < 0 && state == InvoiceState.CLOSED) {
            state = InvoiceState.OPEN;
            closeDate = null;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccountingStatus getStatus() {
        return status;
    }

    public void setStatus(AccountingStatus status) {
        this.status = status;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Invoice{");
        sb.append(super.toString());
        sb.append(", state=").append(state);
        sb.append(", sumPaid=").append(sumPaid);
        sb.append(", sumCharged=").append(sumCharged);
        sb.append(", balance=").append(balance);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", closeDate=").append(closeDate != null ? closeDate.toString() : null);
        sb.append(", lastChargeDate=").append(lastChargeDate != null ? lastChargeDate.toString() : null);
        sb.append(", lastPaymentDate=").append(lastPaymentDate != null ? lastPaymentDate.toString() : null);
        sb.append(", subscriber=").append(subscriber);
        sb.append(", charges=").append(charges);
        sb.append(", payments=").append(payments);
        sb.append(", refunds=").append(refunds).append('}');
        sb.append(", status=").append(status);
        return sb.toString();
    }
    
    
}
