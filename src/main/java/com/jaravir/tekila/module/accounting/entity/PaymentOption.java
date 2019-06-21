package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

import java.util.List;

/**
 * Created by kmaharov on 01.07.2016.
 */
public class PaymentOption extends BaseEntity {
    String name;
    List<Payment> payments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
