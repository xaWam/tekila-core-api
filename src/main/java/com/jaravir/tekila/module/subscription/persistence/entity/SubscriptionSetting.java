/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceSetting;

/**
 *
 * @author sajabrayilov
 */
public class SubscriptionSetting extends BaseEntity{
    private ServiceSetting properties;
    private String value;
    private String dsc;
    
    public SubscriptionSetting() {}
    
    public SubscriptionSetting(ServiceSetting set) {
        this.properties = set;
    }
    
    public ServiceSetting getProperties() {
        return properties;
    }

    public void setProperties(ServiceSetting properties) {
        this.properties = properties;
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubscriptionSetting{").append("properties=").append(properties);
        sb.append(", value=").append(value);
        sb.append(", ").append(super.toString());
        sb.append("}");
        return sb.toString();
    }
    
    
}
