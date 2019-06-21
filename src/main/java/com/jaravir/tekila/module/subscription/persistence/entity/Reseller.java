package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.provision.broadband.devices.MiniPop;

import java.util.List;

public class Reseller extends BaseEntity {
    private String name;
    private String username;
    private String password;
    private User user;
    private List<MiniPop> minipops;
    private ServiceProvider provider;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MiniPop> getMinipops() {
        return minipops;
    }

    public void setMinipops(List<MiniPop> minipops) {
        this.minipops = minipops;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
