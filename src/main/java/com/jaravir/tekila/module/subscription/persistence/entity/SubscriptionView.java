package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.base.entity.Language;

import java.util.Date;

/**
 * Created by sajabrayilov on 1/19/2015.
 */
public class SubscriptionView extends BaseEntity {
    private String agreement;
    private String service;
    private SubscriptionStatus status;
    private Long subscription_id;

    //subscriber info
    private String firstName;
    private String middleName;
    private String surname;
    private String cityOfBirth;
    private Date creationdate;
    private String entryDate;
    private String companyName;
    private String bankAccount;

    private Date dateOfBirth;
    private String citizenship;
    //passport info
    private String country;
    private String passportSeries;
    private String passportNumber;

    private String email;
    private String phoneMobile;
    private String phoneMobileAlt;
    private String phoneLandline;
    //address
    private String city;
    private String ats;
    private String street;
    private String building;
    private String apartment;

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
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

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
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

    public String getPhoneMobileAlt() {
        return phoneMobileAlt;
    }

    public void setPhoneMobileAlt(String phoneMobileAlt) {
        this.phoneMobileAlt = phoneMobileAlt;
    }

    public String getPhoneLandline() {
        return phoneLandline;
    }

    public void setPhoneLandline(String phoneLandline) {
        this.phoneLandline = phoneLandline;
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

    public Long getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(Long subscription_id) {
        this.subscription_id = subscription_id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubscriptionView{");
        sb.append(super.toString());
        sb.append("agreement='").append(agreement).append('\'');
        sb.append(", service='").append(service).append('\'');
        sb.append(", status=").append(status);
        sb.append(", subscription_id=").append(subscription_id);
        sb.append(", companyName=").append(companyName);
        sb.append(", bankAccount='").append(bankAccount).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", middleName='").append(middleName).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", cityOfBirth='").append(cityOfBirth).append('\'');
        sb.append(", creationdate=").append(creationdate);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", citizenship='").append(citizenship).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", passportSeries='").append(passportSeries).append('\'');
        sb.append(", passportNumber='").append(passportNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneMobile='").append(phoneMobile).append('\'');
        sb.append(", phoneMobileAlt='").append(phoneMobileAlt).append('\'');
        sb.append(", phoneLandline='").append(phoneLandline).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", ats='").append(ats).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", building='").append(building).append('\'');
        sb.append(", apartment='").append(apartment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

