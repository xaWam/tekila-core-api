package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

import java.io.Serializable;

/**
 * Created by khsadigov on 6/14/2016.
 */
public class Streets extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    String  atsIndex;
    long streetIndex;
    String name;

    public String getAtsIndex() {
        return atsIndex;
    }

    public void setAtsIndex(String atsIndex) {
        this.atsIndex = atsIndex;
    }

    public long getStreetIndex() {
        return streetIndex;
    }

    public void setStreetIndex(long streetIndex) {
        this.streetIndex = streetIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
