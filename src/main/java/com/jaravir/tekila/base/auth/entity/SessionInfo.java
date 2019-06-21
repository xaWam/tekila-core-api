/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.base.auth.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import org.joda.time.DateTime;

/**
 *
 * @author sajabrayilov
 */
public class SessionInfo extends BaseEntity {
   private String username;
   private DateTime login_timestamp;
   private String key;
   private Boolean isLoggedIn;
   private DateTime expires_timestamp;
   private String ipAddress;
   private String forwardedFor;
    private String sessionID;

   public SessionInfo() {}
   
    public SessionInfo(String username, String key) {
        this.username = username;
        this.key = key;
        isLoggedIn = true;
        login_timestamp = DateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public DateTime getLogin_timestamp() {
        return login_timestamp;
    }

    public void setLogin_timestamp(DateTime login_timestamp) {
        this.login_timestamp = login_timestamp;
    }

    public String getKey() {
        return key;
    }

    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public DateTime getExpires_timestamp() {
        return expires_timestamp;
    }

    public void setExpires_timestamp(DateTime expires_timestamp) {
        this.expires_timestamp = expires_timestamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getForwardedFor() {
        return forwardedFor;
    }

    public void setForwardedFor(String forwardedFor) {
        this.forwardedFor = forwardedFor;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SessionInfo{");
        sb.append(super.toString());
        sb.append("username='").append(username).append('\'');
        sb.append(", login_timestamp=").append(login_timestamp);
        sb.append(", key='").append(key).append('\'');
        sb.append(", isLoggedIn=").append(isLoggedIn);
        sb.append(", expires_timestamp=").append(expires_timestamp);
        sb.append(", ipAddress='").append(ipAddress).append('\'');
        sb.append(", forwardedFor='").append(forwardedFor).append('\'');
        sb.append(", sessionID='").append(sessionID).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
