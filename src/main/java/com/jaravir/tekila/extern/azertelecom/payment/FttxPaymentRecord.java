package com.jaravir.tekila.extern.azertelecom.payment;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * Created by sajabrayilov on 04.02.2015.
 */
public class FttxPaymentRecord extends BaseEntity {
    private String rrn;
    private String accountid;
    private double amount;
    private String transactionid;
    private String accountAnswer;
    private String paymentAnswer;
    private String currency;
    private String contract;
    private String date_time;
    private String rid;
    private String sessid;
    private String service;
    private long ext_user_id;
    private FttxPaymentRecordType type;

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getAccountAnswer() {
        return accountAnswer;
    }

    public void setAccountAnswer(String accountAnswer) {
        this.accountAnswer = accountAnswer;
    }

    public String getPaymentAnswer() {
        return paymentAnswer;
    }

    public void setPaymentAnswer(String paymentAnswer) {
        this.paymentAnswer = paymentAnswer;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getSessid() {
        return sessid;
    }

    public void setSessid(String sessid) {
        this.sessid = sessid;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public long getExt_user_id() {
        return ext_user_id;
    }

    public void setExt_user_id(long ext_user_id) {
        this.ext_user_id = ext_user_id;
    }

    public FttxPaymentRecordType getType() {
        return type;
    }

    public void setType(FttxPaymentRecordType type) {
        this.type = type;
    }
}
