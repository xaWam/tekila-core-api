package com.jaravir.tekila.module.sales;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * Created by sajabrayilov on 11/19/2014.
 */
public class SalesPerson extends BaseEntity {
    private SalesArea area;
    private String firstName;
    private String middleName;
    private String surname;
    private String code;
    private String email;
    private String phoneMobile;
    private String phoneAlt;
    private String phoneLandline;

    public SalesArea getArea() {
        return area;
    }

    public void setArea(SalesArea area) {
        this.area = area;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getPhoneAlt() {
        return phoneAlt;
    }

    public void setPhoneAlt(String phoneAlt) {
        this.phoneAlt = phoneAlt;
    }

    public String getPhoneLandline() {
        return phoneLandline;
    }

    public void setPhoneLandline(String phoneLandline) {
        this.phoneLandline = phoneLandline;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SalesPerson{");
        sb.append(super.toString());
        sb.append(", area=").append(area);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", middleName='").append(middleName).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneMobile='").append(phoneMobile).append('\'');
        sb.append(", phoneAlt='").append(phoneAlt).append('\'');
        sb.append(", phoneLandline='").append(phoneLandline).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
