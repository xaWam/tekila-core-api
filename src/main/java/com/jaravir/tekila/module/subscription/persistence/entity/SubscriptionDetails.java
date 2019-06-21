package com.jaravir.tekila.module.subscription.persistence.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.base.entity.Language;
import com.jaravir.tekila.jsonview.JsonViews;
import com.jaravir.tekila.module.sales.SalesPerson;

/**
 * Created by sajabrayilov on 11/7/2014.
 */
public class SubscriptionDetails extends BaseEntity {

    private String city;
    private String ats;
    private String street;
    private String building;
    private String apartment;
    private String entrance;
    private String floor;
    @JsonView(JsonViews.SubscriptionDetails.class)
    private Subscription subscription;
    private SalesPerson salesPerson;
    private Language lang;
    private String desc;
    private String name;
    private String surname;
    private String password;
    private String comments;
    private boolean isAvailableEcare;

    public SubscriptionDetails() {
    }

    public SubscriptionDetails(Subscriber subscriber) {
        this(subscriber.getDetails());
    }

    public SubscriptionDetails(SubscriberDetails details) {
        city = details.getCity();
        ats = details.getAts();
        street = details.getStreet();
        building = details.getBuilding();
        apartment = details.getApartment();
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAts() {
        return ats;
    }

    public void setAts(String ats) {
        this.ats = ats;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public SalesPerson getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(SalesPerson salesPerson) {
        this.salesPerson = salesPerson;
    }

    public Language getLanguage() {
        return lang;
    }

    public void setLanguage(Language lang) {
        this.lang = lang;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isAvailableEcare() {
        return isAvailableEcare;
    }

    public void setAvailableEcare(boolean availableEcare) {
        isAvailableEcare = availableEcare;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubscriptionDetails{");
        sb.append(super.toString());
        sb.append(", lang=").append(lang);
        sb.append(" city='").append(city).append('\'');
        sb.append(", ats='").append(ats).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", building='").append(building).append('\'');
        sb.append(", apartment='").append(apartment).append('\'');
        sb.append(", salesPerson=").append(salesPerson).append('\'');
        //sb.append(", subscription=").append(subscription);
        sb.append('}');
        return sb.toString();
    }
}
