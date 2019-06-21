/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 *
 * @author sajabrayilov
 */
public class Bank extends BaseEntity {
    private String name;
    private String account;
    private String bic;
    private Currency currency;
    private String dsc;
    private Bank parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Bank getParent() {
        return parent;
    }

    public void setParent(Bank parent) {
        this.parent = parent;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
    public String getFullName() {
        return String.format("%s (%s) BIC %s ACC: %s", name, currency.getCode(), bic, account);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bank{");
        sb.append(super.toString());
        sb.append(", name=").append(name);
        sb.append(", currency=").append(currency);
        sb.append(", bic=").append(bic);
        sb.append(", account=").append(account);
        sb.append(", parent=").append(parent);
        sb.append(", dsc=").append(dsc);
        return sb.append('}').toString();
    }
}
