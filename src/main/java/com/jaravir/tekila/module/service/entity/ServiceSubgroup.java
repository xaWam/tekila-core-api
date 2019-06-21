package com.jaravir.tekila.module.service.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.ServiceType;

/**
 * Created by shnovruzov on 8/25/2016.
 */
public class ServiceSubgroup extends BaseEntity {
    private String name;
    private ServiceProvider provider;
    private ServiceType type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }
}
