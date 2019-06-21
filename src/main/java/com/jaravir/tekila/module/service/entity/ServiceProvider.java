/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.service.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * @author khsadigov, kmaharov, elmarmammadov
 */
public class ServiceProvider extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
