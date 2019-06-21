package com.jaravir.tekila.module.store.equip;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.common.device.DeviceStatus;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.module.store.equip.price.EquipmentPrice;

/**
 * Created by sajabrayilov on 12/18/2014.
 */
public class Equipment extends BaseEntity {
    private String partNumber;
    private EquipmentModel model;
    private EquipmentStatus status;
    private String macAddress;
    private EquipmentBrand brand;
    private EquipmentType type;
    private EquipmentPrice price;
    private ServiceProvider provider;
    private DeviceStatus deviceStatus;

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public EquipmentModel getModel() {
        return model;
    }

    public void setModel(EquipmentModel model) {
        this.model = model;
    }

    public EquipmentStatus getStatus() {
        return status;
    }

    public void setStatus(EquipmentStatus status) {
        this.status = status;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public EquipmentBrand getBrand() {
        return brand;
    }

    public void setBrand(EquipmentBrand brand) {
        this.brand = brand;
    }

    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

    public EquipmentPrice getPrice() {
        return price;
    }

    public void setPrice(EquipmentPrice price) {
        this.price = price;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public void reserve () {
        if (status == null || status != EquipmentStatus.RESERVED)
            status = EquipmentStatus.RESERVED;
    }

    public void free() {
        if (status == null || status == EquipmentStatus.RESERVED)
            status = EquipmentStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "partNumber='" + partNumber + '\'' +
                ", model=" + model +
                ", status=" + status +
                ", macAddress='" + macAddress + '\'' +
                ", brand=" + brand +
                ", type=" + type +
                ", price=" + price +
                ", provider=" + provider +
                ", deviceStatus=" + deviceStatus +
                '}';
    }
}
