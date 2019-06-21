package com.jaravir.tekila.module.service.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

import java.text.DecimalFormat;
import java.util.Objects;

public class ServiceProperty extends BaseEntity {
    private Service service;
    private Zone zone;
    private long price;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ServiceProperty that = (ServiceProperty) o;
        return price == that.price &&
                Objects.equals(service, that.service) &&
                Objects.equals(zone, that.zone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), service, zone, price);
    }

    @Override
    public String toString() {
        return "ServiceProperty{" +
                "service=" + service +
                ", zone=" + zone +
                ", price=" + price +
                ", id=" + id +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }

    public double getServicePriceInDouble() {
        double val = this.price / 100000D;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return Double.parseDouble(decimalFormat.format(val));
    }

    public void setServicePriceInDouble(double price) {
        this.price = Double.valueOf(price*100000).longValue();
    }
}
