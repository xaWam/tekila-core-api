package com.jaravir.tekila.module.accounting.entity;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.jsonview.JsonViews;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;
import org.joda.time.DateTime;

public class Transaction extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 4857594303779698349L;
    private TransactionType type;
    private long startBalance;
    private long endBalance;
    @JsonView(JsonViews.Transaction.class)
    private Subscription subscription;
    private long amount;
    private String dsc;




    public void setLastUpdateDate(Date date) {
        super.lastUpdateDate = new DateTime(date);
    }

    public Transaction() {
    }

    public Transaction(TransactionType type) {
        this.type = type;
    }

    public Transaction(TransactionType type, Subscription sub) {
        this(type);
        this.subscription = sub;
    }

    public Transaction(TransactionType type, Subscription sub, long amount) {
        this(type, sub);
        this.amount = amount;
    }

    public Transaction(TransactionType type, Subscription subscription, long amount, String dsc) {
        this.type = type;
        this.subscription = subscription;
        this.amount = amount;
        this.dsc = dsc;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public long getStartBalance() {
        return startBalance;
    }

    public long getEndBalance() {
        return endBalance;
    }

    public Subscription getSubscription() {
        return this.subscription;
    }

    public TransactionType getType() {
        return this.type;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getAmountAsDouble() {
        double interm = amount / 100000d;
        //return Long.valueOf(interm).doubleValue();
        return String.format("%.5f", interm);
    }

    public void setAmountAsDouble(String amount) {
    }

    public String getStartBalanceAsDouble() {
        double interm = startBalance / 100000d;
        //return Long.valueOf(interm).doubleValue();
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);
        return String.format("%.2f", interm);
    }

    public void setStartBalanceAsDouble(String amount) {
    }

    public String getEndBalanceAsDouble() {
        double interm = endBalance / 100000d;
        //return Long.valueOf(interm).doubleValue();
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);
        return String.format("%.2f", interm);
    }

    public void setEndBalanceAsDouble(String amount) {
    }

    public void execute() {
        this.startBalance = this.subscription.getBalance().getRealBalance();

        // if (type !=  TransactionType.PAYMENT_VAT)
        this.changeBalanceByType();

        if(Math.abs(this.subscription.getBalance().getRealBalance()) <= 1)
            this.subscription.getBalance().setRealBalance(0);

        this.endBalance = this.subscription.getBalance().getRealBalance();
    }

    private void changeBalanceByType() {

        System.out.println("ChangeBalance: AGREEMENT: "+subscription.getAgreement() + " BALANCE: "+subscription.getBalance().getRealBalance() + " AMOUNT: "+this.amount);

        switch (this.type) {
            case OVERWRITE:
                this.subscription.getBalance().overwriteReal(this.amount);
                break;
            case CREDIT:
                this.subscription.getBalance().creditReal(amount);
                break;
            case DEBIT:
                this.subscription.getBalance().debitReal(this.amount);
                break;
            case PAYMENT:
            case PAYMENT_VAT:
                this.subscription.getBalance().creditReal(this.amount);
                break;
        }
    }

    public void executePromo() {
        this.startBalance = this.subscription.getBalance().getPromoBalance();
        this.changePromoBalanceByType();
        this.endBalance = this.subscription.getBalance().getPromoBalance();
    }

    private void changePromoBalanceByType() {
        switch (this.type) {
            case DEBIT_PROMO:
                this.subscription.getBalance().debitPromo(this.amount);
                break;
            case CREDIT_PROMO:
                this.subscription.getBalance().creditPromo(this.amount);
                break;
        }
    }
}
