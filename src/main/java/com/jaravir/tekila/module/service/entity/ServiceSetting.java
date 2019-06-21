/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.service.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.ServiceSettingType;
import com.jaravir.tekila.module.service.ServiceType;

/**
 *
 * @author sajabrayilov
 */
public class ServiceSetting extends BaseEntity {
    private String title;    
    private ServiceSettingType type;
    private ServiceType serviceType;
    private ServiceProvider provider;
    private String dsc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public ServiceSettingType getType() {
        return type;
    }

    public void setType(ServiceSettingType type) {
        this.type = type;
    }   

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }   

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceSetting {").append("title=").append(title);
        sb.append(", type=").append(type);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", provider=").append(provider);
        sb.append(", ").append(super.toString());
        return sb.toString();
    }
}
