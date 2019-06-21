package com.jaravir.tekila.module.archive.subscription;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.base.entity.Language;
import com.jaravir.tekila.module.accounting.entity.TaxationCategory;
import com.jaravir.tekila.module.subscription.persistence.entity.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * Created by sajabrayilov on 22.01.2015.
 */
public class SubscriberArchived extends BaseEntity {
    private User user;
    private DateTime archivedDate;
    private Long objectVersion;
    private SubscriberDetails subscriberDetails;

    private Long master_account;
    private boolean isBilledByLifeCycle;
    private SubscriberLifeCycleType lifeCycle;
    private TaxationCategory taxCategory;
    private Date creationDate;

    //details
    private SubscriberType type;
    private Gender gender;
    private String firstName;
    private String middleName;
    private String surname;
    private String cityOfBirth;

    private Date dateOfBirth;
    private String citizenship;
    private Language lang;
    //passport info
    private String country;
    private String passportSeries;
    private String passportNumber;
    private String passportAuthority;
    private String passportValidTill;
    private Date passportIssueDate;
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
    private Subscriber subscriber;

    /*Corporate
     * general info
     */
    private String companyName;
    private CompanyType companyType;
    private String bankAccount;
    private Date entryDate;

    public SubscriberArchived() {}

    public SubscriberArchived(SubscriberDetails details) {
        this.master_account = details.getSubscriber().getMasterAccount();
        this.isBilledByLifeCycle = details.getSubscriber().getBilledByLifeCycle();
        this.lifeCycle = details.getSubscriber().getLifeCycle();
        this.taxCategory = details.getSubscriber().getTaxCategory();
        this.creationDate = details.getSubscriber().getCreationDate();

        this.archivedDate = DateTime.now();
        this.objectVersion = Long.valueOf(archivedDate.toString(DateTimeFormat.forPattern("yyyyMMddHHmmss")));
        this.subscriberDetails = details;
        this.type = details.getType();
        this.gender = details.getGender();
        this.firstName = details.getFirstName();
        this.middleName = details.getMiddleName();
        this.surname = details.getSurname();
        this.cityOfBirth = details.getCityOfBirth();
        this.dateOfBirth = details.getDateOfBirth();
        this.citizenship = details.getCitizenship();
        this.lang = details.getLanguage();
        this.country = details.getCountry();
        this.passportSeries = details.getPassportSeries();
        this.passportNumber = details.getPassportNumber();
        this.passportAuthority = details.getPassportAuthority();
        this.passportValidTill = details.getPassportValidTill();
        this.passportIssueDate = details.getPassportIssueDate();
        this.email = details.getEmail();
        this.phoneMobile = details.getPhoneMobile();
        this.phoneMobileAlt = details.getPhoneMobileAlt();
        this.phoneLandline = details.getPhoneLandline();
        this.city = details.getCity();
        this.ats = details.getAts();
        this.street = details.getStreet();
        this.building = details.getStreet();
        this.apartment = details.getApartment();
        this.subscriber = details.getSubscriber();
        this.companyName = details.getCompanyName();
        this.companyType = details.getCompanyType();
        this.bankAccount = details.getBankAccount();
        this.entryDate = details.getEntryDate();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SubscriberType getType() {
        return type;
    }

    public void setType(SubscriberType type) {
        this.type = type;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
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

    public String getPassportAuthority() {
        return passportAuthority;
    }

    public void setPassportAuthority(String passportAuthority) {
        this.passportAuthority = passportAuthority;
    }

    public String getPassportValidTill() {
        return passportValidTill;
    }

    public void setPassportValidTill(String passportValidTill) {
        this.passportValidTill = passportValidTill;
    }

    public Date getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(Date passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
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

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public DateTime getArchivedDate() {
        return archivedDate;
    }

    public void setArchivedDate(DateTime archivedDate) {
        this.archivedDate = archivedDate;
    }

    public Long getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(Long objectVersion) {
        this.objectVersion = objectVersion;
    }

    public SubscriberDetails getSubscriberDetails() {
        return subscriberDetails;
    }

    public void setSubscriberDetails(SubscriberDetails subscriberDetails) {
        this.subscriberDetails = subscriberDetails;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Long getMaster_account() {
        return master_account;
    }

    public void setMaster_account(Long master_account) {
        this.master_account = master_account;
    }

    public boolean isBilledByLifeCycle() {
        return isBilledByLifeCycle;
    }

    public void setBilledByLifeCycle(boolean isBilledByLifeCycle) {
        this.isBilledByLifeCycle = isBilledByLifeCycle;
    }

    public SubscriberLifeCycleType getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(SubscriberLifeCycleType lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public TaxationCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxationCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getArchivedAsDate () {
        if (archivedDate != null) {
            return archivedDate.toDate();
        }

        return null;
    }


}
