package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.provision.broadband.devices.Midipop;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shnovruzov on 5/19/2016.
 */
public class Ats extends BaseEntity implements Serializable {
    String name;
    String coor;
    String atsIndex;
    List<Midipop> midipopList;
    AtsStatus status;
    int gov;
    ServiceProvider provider;

    public int getGov() {
        return gov;
    }

    public void setGov(int gov) {
        this.gov = gov;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoor() {
        return coor;
    }

    public void setCoor(String coor) {
        this.coor = coor;
    }

    public String getAtsIndex() {
        return atsIndex;
    }

    public void setAtsIndex(String atsIndex) {
        this.atsIndex = atsIndex;
    }

    public List<Midipop> getMidipopList() {
        return midipopList;
    }

    public void setMidipopList(List<Midipop> midipopList) {
        this.midipopList = midipopList;
    }

    public AtsStatus getStatus() {
        return status;
    }

    public void setStatus(AtsStatus status) {
        this.status = status;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }
}

