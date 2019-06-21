/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.jaravir.tekila.module.accounting.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.auth.persistence.ExternalUser;
import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.jsonview.JsonViews;
import com.jaravir.tekila.module.accounting.PaymentMethod;
import com.jaravir.tekila.module.accounting.PaymentPurpose;
import com.jaravir.tekila.module.service.entity.Service;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;

import java.util.Date;

/**
 * @author sajabrayilov
 */
public class Payment extends BaseEntity {
    private String rrn;
    private String rid;
    private String sessid;
    @JsonView(JsonViews.Payment.class)
    private Subscription account;
    private String contract;
    private Service service;
    private Double amount;
    private String currency;
    private String datetime;
    private String dsc;
    private User user;
    private int status;
    private ExternalUser ext_user;
    private int processed;
    private long user_id;
    private PaymentOption method;
    private String chequeID;
    private Date fd;
    private Long subscriber_id;
    private PaymentPurpose purpose;
    private Transaction transaction;
    private String internalDsc;
    private boolean testPayment;
    private Long campaignId;

    public Payment() {
    }

    public Payment(String rrn, String sessid, Subscription account, String contract, Service service, Double amount, String currency, String datetime) {
        this.rrn = rrn;
        this.sessid = sessid;
        this.account = account;
        this.contract = contract;
        this.service = service;
        this.amount = amount;
        this.currency = currency;
        this.datetime = datetime;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
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

    public Subscription getAccount() {
        return account;
    }

    public void setAccount(Subscription account) {
        this.account = account;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Service getService() {
        return service;
    }

    public void setServiceId(Service service) {
        this.service = service;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDateTime() {
        return datetime;
    }

    public String getMethodForUI() {
        if (method == null) {
            return null;
        }

        return method.getName();
    }

    public void setDateTime(String datetime) {
        this.datetime = datetime;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ExternalUser getExtUser() {
        return ext_user;
    }

    public void setExtUser(ExternalUser extUser) {
        this.ext_user = extUser;
    }

    public int getProcessed() {
        return processed;
    }

    public void setProcessed(int processed) {
        this.processed = processed;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getChequeID() {
        return chequeID;
    }

    public void setChequeID(String cheque) {
        this.chequeID = cheque;
    }

    public Date getFd() {
        return fd;
    }

    public void setFd(Date fd) {
        this.fd = fd;
    }

    public PaymentOption getMethod() {
        return method;
    }

    public void setMethod(PaymentOption method) {
        this.method = method;
    }


    public Long getSubscriber_id() {
        return subscriber_id;
    }

    public void setSubscriber_id(Long subscriber_id) {
        this.subscriber_id = subscriber_id;
    }

    public long getAmountAsLong() {
        Float am = amount.floatValue() * 100000;
        return am.longValue();
    }

    public PaymentPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(PaymentPurpose purpose) {
        this.purpose = purpose;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getInternalDsc() {
        return internalDsc;
    }

    public void setInternalDsc(String internalDsc) {
        this.internalDsc = internalDsc;
    }

    public boolean isTestPayment() {
        return testPayment;
    }

    public void setTestPayment(boolean testPayment) {
        this.testPayment = testPayment;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Payment{");
        sb.append(super.toString());
        sb.append(", subscriber_id=").append(subscriber_id);
        sb.append(", fd=").append(fd);
        sb.append(", rrn=").append(rrn);
        sb.append(", rid=").append(rid);
        sb.append(", sessid=").append(sessid);
        sb.append(", account=").append(account);
        sb.append(", contract=").append(contract);
        sb.append(", service=").append(service);
        sb.append(", amount=").append(amount);
        sb.append(", currency=").append(currency);
        sb.append(", datetime=").append(datetime);
        sb.append(", dsc=").append(dsc);
        sb.append(", user=").append(user);
        sb.append(", status=").append(status);
        sb.append(", ext_user=").append(ext_user);
        sb.append(", processed=").append(processed);
        sb.append(", user_id=").append(user_id);
        sb.append(", method=").append(method);
        sb.append(", purpose=").append(purpose);
        sb.append(", testPayment=").append(testPayment);
        sb.append(", campaignId=").append(campaignId);
        sb.append('}');

        return sb.toString();
    }


}