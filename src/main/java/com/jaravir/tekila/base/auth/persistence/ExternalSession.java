package com.jaravir.tekila.base.auth.persistence;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 *
 * @author khsadigov
 */
public class ExternalSession extends BaseEntity {

    private String session;
    private Integer userType;
    private String remoteAddress;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

}
