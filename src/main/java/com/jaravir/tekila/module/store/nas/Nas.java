package com.jaravir.tekila.module.store.nas;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.module.store.ip.persistence.IpAddressRange;

import java.util.List;

/**
 * Created by shnovruzov on 6/2/2016.
 */
public class Nas extends BaseEntity{
    private String name;
    private String IP;
    private String secretKey;
    private String description;
    private ServiceProvider provider;
    private List<Attribute> attributeList;

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public List<Attribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "[id=" + id+
                "Name =" + name +
                ", IP=" + IP +
                ", secretKey=" + secretKey +
                ", desc=" + description +
                ", lastUpdateDate=" + lastUpdateDate.toString() + "]";
    }
}
