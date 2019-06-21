package com.jaravir.tekila.module.store.mobile;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.base.entity.Util;
import com.jaravir.tekila.module.accounting.entity.TaxationCategory;

/**
 * Created by sajabrayilov on 01.04.2015.
 */
public class CommercialCategory extends BaseEntity {
    private String name;
    private long price;
    private TaxationCategory taxCategory;
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaxationCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxationCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    public String getPriceForView() {
        return Util.convertFromLongToString(price);
    }
}
