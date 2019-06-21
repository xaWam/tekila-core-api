package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.base.entity.Util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by sajabrayilov on 12.02.2015.
 */
public class SubscriptionVASSetting extends BaseEntity {
    private String name;
    private String value;
    private String length;
    private long total;
    private String dsc;

    public SubscriptionVASSetting() {}

    public SubscriptionVASSetting(String name, String value, String dsc) {
        this.name = name;
        this.value = value;
        this.dsc = dsc;
    }

    public SubscriptionVASSetting(String name, String value, String length, String dsc) {
        this.name = name;
        this.value = value;
        this.length = length;
        this.dsc = dsc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public long getTotal() {
        if (value != null || length != null) {
            long price = Util.parseAmountFromStringIntoLong(value, null);
            long ln = Util.parseAmountFromStringIntoLong(length, null);
            total = (price * ln) / 100000;
        }
        return total;
    }

    public String getTotalForView() {
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);
        return String.format("%.2f", getTotal() / 100000d);
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
