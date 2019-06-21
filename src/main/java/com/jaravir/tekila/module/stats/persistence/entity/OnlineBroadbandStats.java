/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.stats.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.util.Date;

/**
 *
 * @author sajabrayilov
 */
public class OnlineBroadbandStats extends BaseEntity {
    private ServiceProvider provider;
    private String down;
    private String up;
    private String user;
    private Date startTime;
    private Date endTime;
    private String callingStationID;
    private String framedAddress;
    private String nasIpAddress;
    private String accountID;
    private String service;
    private String dslamIpAddress;

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCallingStationID() {
        return callingStationID;
    }

    public void setCallingStationID(String callingStationID) {
        this.callingStationID = callingStationID;
    }

    public String getFramedAddress() {
        return framedAddress;
    }

    public void setFramedAddress(String framedAddress) {
        this.framedAddress = framedAddress;
    }

    public String getNasIpAddress() {
        return nasIpAddress;
    }

    public void setNasIpAddress(String nasIpAddress) {
        this.nasIpAddress = nasIpAddress;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDslamIpAddress() {
        return dslamIpAddress;
    }

    public void setDslamIpAddress(String dslamIpAddress) {
        this.dslamIpAddress = dslamIpAddress;
    }

    public String getDuration() {
        if (startTime == null)
            return null;

        Period period = new Interval(new DateTime(startTime), DateTime.now()).toPeriod();

        PeriodFormatter pf = new PeriodFormatterBuilder()
                .appendMonths().appendSuffix("m ")
                .appendDays().appendSuffix("d ")
                .printZeroAlways()
                .appendHours().appendSuffix("h ")
                .appendMinutes().appendSeparator(":")
                .appendSeconds().appendSeparator(":")
                .toFormatter();

        return pf.print(period);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OnlineBroadbandStats{");
        sb.append(super.toString());
        sb.append(", provider=").append(provider);
        sb.append(", down='").append(down).append('\'');
        sb.append(", up='").append(up).append('\'');
        sb.append(", user='").append(user).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", callingStationID='").append(callingStationID).append('\'');
        sb.append(", framedAddress='").append(framedAddress).append('\'');
        sb.append(", nasIpAddress='").append(nasIpAddress).append('\'');
        sb.append(", dslam='").append(dslamIpAddress).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
