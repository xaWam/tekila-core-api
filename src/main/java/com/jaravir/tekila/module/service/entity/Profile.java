package com.jaravir.tekila.module.service.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

import java.util.Objects;

public class Profile extends BaseEntity {
    private String name;
    private ProfileType profileType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Profile profile = (Profile) o;
        return Objects.equals(name, profile.name) &&
                profileType == profile.profileType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, profileType);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", profileType=" + profileType +
                '}';
    }
}
