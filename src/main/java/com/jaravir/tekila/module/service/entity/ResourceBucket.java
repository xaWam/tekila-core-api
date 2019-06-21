package com.jaravir.tekila.module.service.entity;

import java.io.Serializable;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.ResourceBucketType;

public class ResourceBucket extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6821838453578239663L;
    private String capacity;
    private ResourceBucketType type;
    private String dsc;
    private String unit;

    public ResourceBucket() {
    }

    public ResourceBucket(ResourceBucket buck) {
        this.type = buck.getType();
        this.capacity = buck.getCapacity();
        this.dsc = buck.getDsc();
    }

    public ResourceBucket(String capacity, ResourceBucketType type) {
        this.capacity = capacity;
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCapacity() {
        return capacity;
    }

    public ResourceBucketType getType() {
        return this.type;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setType(ResourceBucketType type) {
        this.type = type;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((capacity == null) ? 0 : capacity.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof ResourceBucket)) {
            return false;
        }
        ResourceBucket other = (ResourceBucket) obj;
        if (capacity == null) {
            if (other.capacity != null) {
                return false;
            }
        } else if (!capacity.equals(other.capacity)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResourceBucket{" + "capacity=" + capacity + ", type=" + type + ", dsc=" + dsc + '}';
    }
}
