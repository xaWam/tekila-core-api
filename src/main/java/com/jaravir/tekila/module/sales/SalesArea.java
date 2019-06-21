package com.jaravir.tekila.module.sales;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * Created by sajabrayilov on 11/19/2014.
 */
public class SalesArea extends BaseEntity {
    private String city;
    private String name;
    private String code;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SalesArea{");
        sb.append(super.toString());
        sb.append(", city='").append(city).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
