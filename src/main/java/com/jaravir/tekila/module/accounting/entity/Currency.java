/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 *
 * @author sajabrayilov
 */
public class Currency extends BaseEntity {
    private String code;
    private String dsc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Currency{");
        sb.append(super.toString());
        sb.append(", code=").append(code);
        sb.append(", desc=").append(dsc);
        return sb.append('}').toString();
    }
}
