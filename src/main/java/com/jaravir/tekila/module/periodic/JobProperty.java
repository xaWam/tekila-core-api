package com.jaravir.tekila.module.periodic;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * Created by sajabrayilov on 5/4/2015.
 */
public class JobProperty extends BaseEntity {
    private JobPropertyType type;
    private String value;

    public JobPropertyType getType() {
        return type;
    }

    public void setType (JobPropertyType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
