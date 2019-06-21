package com.jaravir.tekila.module.service.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

import java.util.Objects;

public class Zone extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Zone zone = (Zone) o;
        return Objects.equals(name, zone.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "Zone{" +
                "name='" + name + '\'' +
                '}';
    }
}
