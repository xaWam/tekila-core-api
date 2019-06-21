package com.jaravir.tekila.module.store.equip.price;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * Created by sajabrayilov on 12/19/2014.
 */
public class EquipmentPrice extends BaseEntity {
    private long nominal;
    private double discount;

    public long getPrice() {
        return nominal;
    }

    public void setPrice(long price) {
        this.nominal = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getNominalForView () {
        double interm = nominal / 100000d;
        //return Long.valueOf(interm).doubleValue();
        return String.format("%.5f", interm);
    }

    public String getDiscountForView () {
        //return Long.valueOf(interm).doubleValue();
        return String.format("%.2f", discount);
    }
}
