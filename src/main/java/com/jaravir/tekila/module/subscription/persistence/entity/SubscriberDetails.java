package com.jaravir.tekila.module.subscription.persistence.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jaravir.tekila.base.entity.Language;
import com.jaravir.tekila.jsonview.JsonViews;


public class SubscriberDetails extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -3510221504105892822L;
	private User user;
	/* individual
	general info */
	private SubscriberType type = SubscriberType.INDV;
	private Gender gender;
	private String firstName;
	private String middleName;
	private String surname;
	private String cityOfBirth;
	private Date entryDate;

	private String comments;
	private Date dateOfBirth;
	private String citizenship = "Azerbaijan";
	private Language lang;
	//passport info
	private String country = "Azerbaijan";
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
	@JsonView(JsonViews.SubscriberDetails.class)
	private Subscriber subscriber;
	private String pinCode;
	/*Corporate
	 * general info
	 */
	private String companyName;
	private CompanyType companyType;
	private String bankAccount;

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
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

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Language getLanguage() {
		return lang;
	}

	public void setLanguage(Language lang) {
		this.lang = lang;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((apartment == null) ? 0 : apartment.hashCode());
		result = prime * result + ((ats == null) ? 0 : ats.hashCode());
		result = prime * result
				+ ((bankAccount == null) ? 0 : bankAccount.hashCode());
		result = prime * result
				+ ((building == null) ? 0 : building.hashCode());
		result = prime * result
				+ ((citizenship == null) ? 0 : citizenship.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((cityOfBirth == null) ? 0 : cityOfBirth.hashCode());
		result = prime * result
				+ ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result
				+ ((companyType == null) ? 0 : companyType.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((middleName == null) ? 0 : middleName.hashCode());
		result = prime
				* result
				+ ((passportAuthority == null) ? 0 : passportAuthority
						.hashCode());
		result = prime
				* result
				+ ((passportIssueDate == null) ? 0 : passportIssueDate
						.hashCode());
		result = prime * result
				+ ((passportNumber == null) ? 0 : passportNumber.hashCode());
		result = prime * result
				+ ((passportSeries == null) ? 0 : passportSeries.hashCode());
		result = prime
				* result
				+ ((passportValidTill == null) ? 0 : passportValidTill
						.hashCode());
		result = prime * result
				+ ((phoneLandline == null) ? 0 : phoneLandline.hashCode());
		result = prime * result
				+ ((phoneMobile == null) ? 0 : phoneMobile.hashCode());
		result = prime * result
				+ ((phoneMobileAlt == null) ? 0 : phoneMobileAlt.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result
				+ ((subscriber == null) ? 0 : subscriber.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof SubscriberDetails))
			return false;
		SubscriberDetails other = (SubscriberDetails) obj;
		if (apartment == null) {
			if (other.apartment != null)
				return false;
		} else if (!apartment.equals(other.apartment))
			return false;
		if (ats == null) {
			if (other.ats != null)
				return false;
		} else if (!ats.equals(other.ats))
			return false;
		if (bankAccount == null) {
			if (other.bankAccount != null)
				return false;
		} else if (!bankAccount.equals(other.bankAccount))
			return false;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (citizenship == null) {
			if (other.citizenship != null)
				return false;
		} else if (!citizenship.equals(other.citizenship))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (cityOfBirth == null) {
			if (other.cityOfBirth != null)
				return false;
		} else if (!cityOfBirth.equals(other.cityOfBirth))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (companyType != other.companyType)
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (passportAuthority == null) {
			if (other.passportAuthority != null)
				return false;
		} else if (!passportAuthority.equals(other.passportAuthority))
			return false;
		if (passportIssueDate == null) {
			if (other.passportIssueDate != null)
				return false;
		} else if (!passportIssueDate.equals(other.passportIssueDate))
			return false;
		if (passportNumber == null) {
			if (other.passportNumber != null)
				return false;
		} else if (!passportNumber.equals(other.passportNumber))
			return false;
		if (passportSeries == null) {
			if (other.passportSeries != null)
				return false;
		} else if (!passportSeries.equals(other.passportSeries))
			return false;
		if (passportValidTill == null) {
			if (other.passportValidTill != null)
				return false;
		} else if (!passportValidTill.equals(other.passportValidTill))
			return false;
		if (phoneLandline == null) {
			if (other.phoneLandline != null)
				return false;
		} else if (!phoneLandline.equals(other.phoneLandline))
			return false;
		if (phoneMobile == null) {
			if (other.phoneMobile != null)
				return false;
		} else if (!phoneMobile.equals(other.phoneMobile))
			return false;
		if (phoneMobileAlt == null) {
			if (other.phoneMobileAlt != null)
				return false;
		} else if (!phoneMobileAlt.equals(other.phoneMobileAlt))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.equals(other.subscriber))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SubscriberDetails {");
                                sb.append(super.toString());
                                sb.append(", entryDate=").append(entryDate != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSS").format(entryDate) : null);
                                sb.append(", type=").append(type);
				sb.append(", language=").append(lang);
				sb.append(", gender=").append(gender).append(", firstName=");
				sb.append(firstName).append(", middleName=").append(middleName);
				sb.append(", surname=").append(surname);
				sb.append(", cityOfBirth=").append(cityOfBirth);
				sb.append(", dateOfBirth=").append(dateOfBirth);
				//sb.append(dateOfBirth).append(", citizenship=");
				sb.append(citizenship).append(", country=").append(country);
				sb.append(", passportSeries=").append(passportSeries);
				sb.append(", passportNumber=").append(passportNumber);
				sb.append(", passportAuthority=").append(passportAuthority);
				sb.append(", passportValidTill=").append(passportValidTill);
				sb.append(", passportIssueDate=").append(passportIssueDate != null ? passportIssueDate : null);
				sb.append(", email=").append(email);
                                sb.append(", phoneMobile=").append(phoneMobile);
                                sb.append(", phoneMobileAlt=").append(phoneMobileAlt);
                                sb.append(", phoneLandline=").append(phoneLandline);
                                sb.append(", city=").append(city);
				sb.append(", ats=").append(ats);
                                sb.append(", street=").append(street);
                                sb.append(", building=").append(building);
				sb.append(", apartment=").append(apartment);
				//sb.append(", subscriber=").append(subscriber);
				sb.append(", companyName=").append(companyName);
				sb.append(", companyType=").append(companyType);
				sb.append(", bankAccount=").append(bankAccount);
				sb.append("}");
		return sb.toString();
	}
	

}
