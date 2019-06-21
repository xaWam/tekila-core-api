package com.jaravir.tekila.provision.broadband.devices;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.subscription.persistence.entity.Ats;

import java.util.List;

/**
 * Created by shnovruzov on 7/8/2016.
 */
public class Midipop extends BaseEntity {
    private String name;
    private int status;
    private int cable;
    private int nodes;
    private String switchIp;
    private int switchPort;
    private int vlan;
    private Ats ats;
    private List<MidipopPort> reservedPortList;

    public List<MidipopPort> getReservedPortList() {
        return reservedPortList;
    }

    public void setReservedPortList(List<MidipopPort> reservedPortList) {
        this.reservedPortList = reservedPortList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getVlan() {
        return vlan;
    }

    public void setVlan(int vlan) {
        this.vlan = vlan;
    }

    public int getSwitchPort() {
        return switchPort;
    }

    public void setSwitchPort(int switchPort) {
        this.switchPort = switchPort;
    }

    public String getSwitchIp() {
        return switchIp;
    }

    public void setSwitchIp(String switchIp) {
        this.switchIp = switchIp;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }

    public int getCable() {
        return cable;
    }

    public void setCable(int cable) {
        this.cable = cable;
    }

    public Ats getAts() {
        return ats;
    }
    public void setAts(Ats ats) {
        this.ats = ats;
    }
}
