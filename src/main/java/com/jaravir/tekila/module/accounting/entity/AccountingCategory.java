/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.accounting.AccountingCategoryType;

/**
 *
 * @author sajabrayilov
 */
public class AccountingCategory extends BaseEntity {
    private AccountingCategoryType type;
    private String name;
    private String dsc;
    private TaxationCategory taxCategory;
    private boolean isAdjustment;

    public AccountingCategoryType getType() {
        return type;
    }

    public void setType(AccountingCategoryType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public TaxationCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxationCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    public boolean isAdjustment() {
        return isAdjustment;
    }

    public void setAdjustment(boolean isAdjustment) {
        this.isAdjustment = isAdjustment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AccountingCategory{");
        sb.append(super.toString());
        sb.append(", name=").append(name);
        sb.append(", taxCategory=").append(taxCategory);
        sb.append(", type=").append(type);
        sb.append(", dsc=").append(dsc);
        return sb.append('}').toString();
    }

}
