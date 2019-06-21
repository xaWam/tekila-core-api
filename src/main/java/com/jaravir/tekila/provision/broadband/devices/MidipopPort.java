package com.jaravir.tekila.provision.broadband.devices;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * Created by shnovruzov on 7/11/2016.
 */
public class MidipopPort extends BaseEntity {
    private boolean isOccupied;
    private Midipop midipop;
    private Integer midipopSlot;
    private Integer midipopPort;


    public MidipopPort() {
    }

    public Midipop getMidipop() {
        return midipop;
    }

    public void setMidipop(Midipop midipop) {
        this.midipop = midipop;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Integer getMidipopSlot() {
        return midipopSlot;
    }

    public void setMidipopSlot(Integer midipopSlot) {
        this.midipopSlot = midipopSlot;
    }

    public Integer getMidipopPort() {
        return midipopPort;
    }

    public void setMidipopPort(Integer midipopPort) {
        this.midipopPort = midipopPort;
    }
}
