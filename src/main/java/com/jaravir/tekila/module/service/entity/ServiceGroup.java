/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaravir.tekila.module.service.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.jsonview.JsonViews;
import com.jaravir.tekila.module.service.ServiceType;
import java.util.List;

/**
 *
 * @author sajabrayilov
 */
public class ServiceGroup extends BaseEntity{
    private String name;
    private ServiceProvider provider;
    @JsonView(JsonViews.ServiceGroup.class)
    private List<Service> services;
    private ServiceType type;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ServiceGroup{");
        sb.append(super.toString());
        sb.append(", name=").append(name);
        sb.append(", provider=").append(provider);
        sb.append(", type=").append(type);
        sb.append("}");
        return sb.toString();
    }
}
