/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.accounting.AccountingTransactionType;
import com.jaravir.tekila.module.accounting.FinancialType;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sajabrayilov
 */
public class AccountingTransaction extends BaseEntity {
    private List<Operation> operations;
    private ServiceProvider provider;
    private User user;
    private AccountingTransactionType type;
    private String dsc;
    private boolean isRollback;
    private AccountingTransaction rolledBackTrans;

    public AccountingTransaction () {
        operations = new ArrayList<>();
        //type = AccountingTransactionType.NON_BATCH;
    }
    
    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    
    public void addOperation (Operation op) {
        operations.add(op);
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccountingTransactionType getType() {
        return type;
    }

    public void setType(AccountingTransactionType type) {
        this.type = type;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public boolean getRollback() {
        return isRollback;
    }

    public void setRollback(boolean isRollback) {
        this.isRollback = isRollback;
    }

    public AccountingTransaction getRolledBackTrans() {
        return rolledBackTrans;
    }

    public void setRolledBackTrans(AccountingTransaction rolledBackTrans) {
        this.rolledBackTrans = rolledBackTrans;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AccountingTransaction{");
        sb.append(super.toString());
        sb.append(", provider=").append(provider != null ? provider.toString() : null);
        sb.append(", user=").append(user != null ? user : null);
        sb.append(", type=").append(type);
        sb.append(", operations=").append(operations != null ? operations : null);
        return sb.append('}').toString();
    }
}
