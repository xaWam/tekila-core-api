package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ElmarMa on 6/13/2018
 */
public class AsyncProvisioningTask extends BaseEntity implements Serializable {
    private Date eventTime;
    private EventType eventType;
    private int taskStatus;
    private Long providerId;
    private String account;
    private String username;
    private String password;
    private String mac;
    private String slot;
    private String port;
    private String ip;
    private String dslam;
    private String groupName;
    private String type;
    private Date fd;
    private Date td;
    private Date subscriptionCreated;
    private int status;
    private String newAccount;


    public Date getSubscriptionCreated() {
        return subscriptionCreated;
    }

    public void setSubscriptionCreated(Date subscriptionCreated) {
        this.subscriptionCreated = subscriptionCreated;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDslam() {
        return dslam;
    }

    public void setDslam(String dslam) {
        this.dslam = dslam;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNewAccount() {
        return newAccount;
    }

    public void setNewAccount(String newAccount) {
        this.newAccount = newAccount;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public Date getFd() {
        return fd;
    }

    public void setFd(Date fd) {
        this.fd = fd;
    }

    public Date getTd() {
        return td;
    }

    public void setTd(Date td) {
        this.td = td;
    }
}
