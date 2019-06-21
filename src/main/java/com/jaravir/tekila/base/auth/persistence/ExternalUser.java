package com.jaravir.tekila.base.auth.persistence;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 *
 * @author sajabrayilov
 */
public class ExternalUser extends BaseEntity {

    private String username;
    private String passwd;
    private Integer userType;
    private String allowedAddresses;

    public String getAllowedAddresses() {
        return allowedAddresses;
    }

    public void setAllowedAddresses(String allowedAddresses) {
        this.allowedAddresses = allowedAddresses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

}
