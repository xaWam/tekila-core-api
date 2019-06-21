package com.jaravir.tekila.base.auth.persistence;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.auth.UserStatus;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.jsonview.JsonViews;
import org.joda.time.DateTime;

import javax.persistence.Lob;
import javax.persistence.Transient;

public class User extends BaseEntity {

    private static final long serialVersionUID = -8959998975292953776L;
    private String userName;
    private String password;
    private String dsc;
    @JsonView(JsonViews.User.class)
    private Group group;
    private String email;
    private String firstName;
    private String surname;
    private String middleName;
    private int loginRetryCounter;
    private DateTime blockedDate;
    private DateTime blockedTillDate;
    private DateTime lastLoginDate;
    private UserStatus status;
    private String theme ;
    private DateTime lastPasswordChanged;
    private String usedPasswords;
    private DateTime createdDate;

    public User() {
    }

    public User(String userName, String password, Group group) {
        this.userName = userName;
        this.password = password;
        this.group = group;
    }


    public DateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(DateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getLoginRetryCounter() {
        return loginRetryCounter;
    }

    public void setLoginRetryCounter(int loginRetryCounter) {
        this.loginRetryCounter = loginRetryCounter;
    }

    public void incrementRetryCounter() {
        loginRetryCounter++;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public DateTime getBlockedDate() {
        return blockedDate;
    }

    public void setBlockedDate(DateTime blockedDate) {
        this.blockedDate = blockedDate;
    }

    public DateTime getBlockedTillDate() {
        return blockedTillDate;
    }

    public void setBlockedTillDate(DateTime blockedTillDate) {
        this.blockedTillDate = blockedTillDate;
    }

    public DateTime getLastPasswordChanged() {
        return lastPasswordChanged;
    }

    public void setLastPasswordChanged(DateTime lastPasswordChanged) {
        this.lastPasswordChanged = lastPasswordChanged;
    }

    public String getUsedPasswords() {
        return usedPasswords;
    }

    public void setUsedPasswords(String usedPasswords) {
        this.usedPasswords = usedPasswords;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User{");
        sb.append(super.toString());
        sb.append(", userName=").append(userName);
        sb.append(", dsc=").append(dsc);
        sb.append(", last login date =").append(lastLoginDate);
        sb.append(", group=").append(group);
        sb.append(", email=").append(email);
        sb.append(", name=").append(firstName).append(" ").append(middleName).append(" ").append(surname);
        sb.append(", loginRetryCounter=").append(loginRetryCounter);
        sb.append(", status=").append(status);
        return sb.append("}").toString();
    }
}

