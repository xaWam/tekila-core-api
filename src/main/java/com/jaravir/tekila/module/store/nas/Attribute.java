package com.jaravir.tekila.module.store.nas;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * Created by shnovruzov on 6/8/2016.
 */
public class Attribute extends BaseEntity {
    private String name;
    private int tag;
    private String value;
    private int status;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "[id=" + id+
                "Name =" + name +
                ", IP=" + tag +
                ", secretKey=" + value +
                ", desc=" + status +
                ", lastUpdateDate=" + lastUpdateDate.toString() + "]";
    }
}
