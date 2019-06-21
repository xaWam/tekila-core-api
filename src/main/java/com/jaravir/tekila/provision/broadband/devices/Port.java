/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.provision.broadband.devices;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 *
 * @author sajabrayilov
 */
public class Port extends BaseEntity implements Comparable {
    private int number;
    private boolean isOccupied;

    public Port() {}

    public Port(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Port port = (Port) o;

        //if (isOccupied != port.isOccupied) return false;
        if (number != port.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + number;
        //result = 31 * result + (isOccupied ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        Port port = (Port) o;
        int res = this.getNumber() - port.getNumber();
        if (res > 0)
            res = 1;
        else if (res == 0)
            res = 0;
        else if (res < 0)
            res = -1;

        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Port{");
        sb.append(super.toString());
        sb.append(", number=").append(number);
        sb.append(", isOccupied=").append(isOccupied);
        sb.append('}');
        return sb.toString();
    }
}
