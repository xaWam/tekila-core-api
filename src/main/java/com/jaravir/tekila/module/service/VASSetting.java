package com.jaravir.tekila.module.service;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.subscription.persistence.entity.Balance;

/**
 * Created by sajabrayilov on 12.02.2015.
 */
public class VASSetting extends BaseEntity {
    private String name;
    private String dsc;

    public VASSetting() {
    }

    public VASSetting(String name, String dsc) {
        this.name = name;
        this.dsc = dsc;
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
}
