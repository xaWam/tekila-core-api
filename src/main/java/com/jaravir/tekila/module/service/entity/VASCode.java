/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.service.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.ServiceType;
import com.jaravir.tekila.module.service.ValueAddedServiceType;

/**
 *
 * @author sajabrayilov
 */
public class VASCode extends BaseEntity {
    private ServiceProvider provider;
    private VASCodeSequence generator;
    private ValueAddedServiceType type;
    private String name;
    private String dsc;

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public VASCodeSequence getGenerator() {
        return generator;
    }

    public void setGenerator(VASCodeSequence generator) {
        this.generator = generator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }
    
    public Long getCode() {
        return (generator != null ? generator.getId() : null);
    }

    public ValueAddedServiceType getType() {
        return type;
    }

    public void setType(ValueAddedServiceType type) {
        this.type = type;
    }
        
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VASCode{");
        sb.append(super.toString());
        sb.append(", provider=").append(provider)
        .append(", generator=").append(generator)
        .append(", type=").append(type) 
        .append(", name=").append(name)
        .append(", dsc=").append(dsc).append('}');
        return sb.toString();
    }
    
    
}
