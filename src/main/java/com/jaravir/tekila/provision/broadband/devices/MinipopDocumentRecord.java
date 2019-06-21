package com.jaravir.tekila.provision.broadband.devices;

/**
 * Created by sajabrayilov on 7/13/2015.
 */
public class MinipopDocumentRecord {
    private String macAddress;
    private String switchID;
    private String address;
    private int portsNumber;
    private String status;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getSwitchID() {
        return switchID;
    }

    public void setSwitchID(String switchID) {
        this.switchID = switchID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPortsNumber() {
        return portsNumber;
    }

    public void setPortsNumber(int portsNumber) {
        this.portsNumber = portsNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
