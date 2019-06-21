package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.base.entity.Util;
import com.jaravir.tekila.module.accounting.AccountingStatus;
import com.jaravir.tekila.module.accounting.InvoiceState;
import com.jaravir.tekila.module.sales.persistence.entity.SalesPartner;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sajabrayilov on 11/24/2015.
 */
public class SalesPartnerInvoice extends BaseEntity implements Serializable {
    private InvoiceState state;
    private Long sumPaid;
    private Long sumCharged;
    private Long balance;
    private Date creationDate;
    private DateTime closeDate;
    private DateTime lastChargeDate;
    private DateTime lastPaymentDate;
    private List<SalesPartnerCharge> charges;
    private List<Payment> payments;
    private User user;
    private AccountingStatus status;
    private SalesPartner partner;

    public SalesPartnerInvoice() {
        this.sumCharged = 0L;
        this.sumPaid = 0L;
        this.balance = 0L;
        this.charges = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.state = InvoiceState.OPEN;
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

    public List<SalesPartnerCharge> getCharges() {
        return charges;
    }

    public void setCharges(List<SalesPartnerCharge> charges) {
        this.charges = charges;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
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

    public SalesPartner getPartner() {
        return partner;
    }

    public void setPartner(SalesPartner partner) {
        this.partner = partner;
    }

    public void addCharge (SalesPartnerCharge charge) {
        charges.add(charge);
        balance -= charge.getAmount();
        sumCharged += charge.getAmount();
        lastChargeDate = DateTime.now();
    }

    public String getSumChargedForView () {
        return Util.convertFromLongToString(sumCharged);
    }

    public String getSumPaidForView () {
        return Util.convertFromLongToString(sumPaid);
    }

    public String getBalanceForView () {
        return Util.convertFromLongToString(balance);
    }
}
