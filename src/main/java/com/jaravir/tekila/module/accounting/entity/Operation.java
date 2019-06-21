/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;

/**
 *
 * @author sajabrayilov
 */
public class Operation extends BaseEntity {
    private AccountingCategory category;
    private long amount;
    private Transaction transaction;
    private AccountingTransaction accTransaction;
    private User user;
    private ServiceProvider provider;
    private Subscription subscription;
    private Bank bank;
    private String dsc;
            
    public AccountingCategory getCategory() {
        return category;
    }

    public void setCategory(AccountingCategory category) {
        this.category = category;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public AccountingTransaction getAccTransaction() {
        return accTransaction;
    }

    public void setAccTransaction(AccountingTransaction accTransaction) {
        this.accTransaction = accTransaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Operation{");
        sb.append(super.toString());
        sb.append(", amount=").append(amount);
       // sb.append(", accTransaction=").append(accTransaction != null ? accTransaction : null);
        sb.append(", category=").append(category != null ? category : null);
        sb.append(", provider=").append(provider != null ? provider : null);
        sb.append(", subscription=").append(subscription != null ? subscription : null);
        sb.append(", transaction=").append(transaction != null ? transaction : null);
        sb.append(", user=").append(user);
        sb.append(", bank=").append(bank);
        return sb.append('}').toString();
    }
    
}
