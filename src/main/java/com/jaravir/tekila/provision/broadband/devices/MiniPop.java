/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.provision.broadband.devices;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.common.device.DeviceStatus;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.module.store.nas.Nas;
import com.jaravir.tekila.module.subscription.persistence.entity.Ats;
import com.jaravir.tekila.module.subscription.persistence.entity.House;
import com.jaravir.tekila.module.subscription.persistence.entity.Streets;
import com.jaravir.tekila.provision.broadband.devices.exception.NoFreePortLeftException;
import com.jaravir.tekila.provision.broadband.devices.exception.PortAlreadyReservedException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sajabrayilov
 */
public class MiniPop extends BaseEntity {
    private String switch_id;
    private String mac;
    private String ip;
    private String serial;
    private String model;
    private String address;
    private int numberOfPorts;
    private List<Port> reservedPortList;
    private DeviceStatus deviceStatus;
    private Integer preferredPort;
    private ServiceProvider provider;
    private Ats ats;
    private Nas nas;
    private Streets street;
    private Integer masterVlan;
    private Integer subVlan;
    private Midipop midipop;
    private Integer midipopSlot;
    private Integer midipopPort;
    private String block;
    private List<House> houses;
    private MinipopCategory category;
    public MiniPop() {
        reservedPortList = new ArrayList<>();
    }

    public MiniPop(long id, String switch_id, String mac, String address) {
        this();
        this.id = id;
        this.switch_id = switch_id;
        this.mac = mac;
        this.address = address;
    }

    public MinipopCategory getCategory() {
        return category;
    }

    public void setCategory(MinipopCategory category) {
        this.category = category;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Streets getStreet() {
        return street;
    }

    public void setStreet(Streets street) {
        this.street = street;
    }

    public Integer getMidipopSlot() {
        return midipopSlot;
    }

    public void setMidipopSlot(Integer midipopSlot) {
        this.midipopSlot = midipopSlot;
    }

    public Integer getMidipopPort() {
        return midipopPort;
    }

    public void setMidipopPort(Integer midipopPort) {
        this.midipopPort = midipopPort;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Midipop getMidipop() {
        return midipop;
    }

    public void setMidipop(Midipop midipop) {
        this.midipop = midipop;
    }

    public Integer getMasterVlan() {
        return masterVlan;
    }

    public void setMasterVlan(Integer masterVlan) {
        this.masterVlan = masterVlan;
    }

    public Integer getSubVlan() {
        return subVlan;
    }

    public void setSubVlan(Integer subVlan) {
        this.subVlan = subVlan;
    }

    public Nas getNas() {
        return nas;
    }

    public void setNas(Nas nas) {
        this.nas = nas;
    }

    public Ats getAts() {
        return ats;
    }

    public void setAts(Ats ats) {
        this.ats = ats;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public String getSwitch_id() {
        return switch_id;
    }

    public void setSwitch_id(String switch_id) {
        this.switch_id = switch_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public List<Port> getReservedPortList() {
        return reservedPortList;
    }

    public void setReservedPortList(List<Port> reservedPortList) {
        this.reservedPortList = reservedPortList;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Port reserve() throws NoFreePortLeftException, PortAlreadyReservedException {
        return preferredPort != null ? reserve(preferredPort) : getNextAvailablePort();
    }

    public Port reserve(int portNum) throws PortAlreadyReservedException {
        if (portNum <= 0 || portNum > numberOfPorts)
            throw new IndexOutOfBoundsException(String.format("Port should be in range 1 - %d, but %d provided", numberOfPorts, portNum));

        Port port = null;

        if ((port = getReserved(portNum)) != null) {
            throw new PortAlreadyReservedException();
        }

        port = new Port();
        port.setNumber(portNum);
        port.setIsOccupied(true);
        reservedPortList.add(port);
        return port;
    }

    public void free(int portNum) {
        Port port = null;

        if ((port = getReserved(portNum)) != null) {
            reservedPortList.remove(port);
        }
    }

    public Port getReserved(Port port) {
        for (Port reservedPort : reservedPortList) {
            if (port.equals(reservedPort)) {
                return reservedPort;
            }
        }

        return null;
    }

    public Port getReserved(int port) {
        for (Port reservedPort : reservedPortList) {
            if (reservedPort.getNumber() == port) {
                return reservedPort;
            }
        }

        return null;
    }

    public Port getNextAvailablePortHint() {
        try {
            return getNextAvailablePort(false);
        } catch (NoFreePortLeftException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Integer getNextAvailablePortHintAsNumber() {
        try {
            if (preferredPort == null)
                preferredPort = getNextAvailablePort(false).getNumber();
            return preferredPort;
        } catch (NoFreePortLeftException ex) {
            return null;
        }
    }

    public void setNextAvailablePortHintAsNumber(Integer num) {
        preferredPort = num;
    }

    public Port getNextAvailablePort() throws NoFreePortLeftException {
        return getNextAvailablePort(true);
    }


    public Port getNextAvailablePort(boolean isShouldReserve) throws NoFreePortLeftException {
        if (numberOfPorts == reservedPortList.size()) {
            throw new NoFreePortLeftException();
        }

        List<Port> portList = new ArrayList<>(reservedPortList);
        Port port = null;

        for (int i = 1; i <= numberOfPorts; i++) {
            if ((port = getReserved(i)) == null) {
                try {
                    port = isShouldReserve ? reserve(i) : new Port(i);
                    return port;
                } catch (PortAlreadyReservedException ex) {
                }
            }
        }

        throw new NoFreePortLeftException();
    }

    public int getNumberOfAvailablePorts() {
        return numberOfPorts - reservedPortList.size();
    }

    public String getReservedPortsAsText() {
        if (reservedPortList.size() == 0)
            return "-";

        StringBuilder sb = new StringBuilder();

        for (Port port : reservedPortList) {
            sb.append(port.getNumber()).append(',');
        }

        return sb.substring(0, sb.length() - 1).toString();
    }

    public String getAvailablePortsAsText() {
        if (numberOfPorts == reservedPortList.size())
            return "-";

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= numberOfPorts; i++) {
            if (getReserved(i) == null)
                sb.append(i).append(", ");
        }

        return sb.substring(0, sb.length() - 2).toString();
    }

    public Integer getPreferredPort() {
        return preferredPort;
    }

    public void setPreferredPort(Integer preferredPort) {
        this.preferredPort = preferredPort;
    }

    public boolean checkPort(int num) {
        if (num <= 0 || num > numberOfPorts || this.getReserved(num) != null)
            return false;

        return true;
    }

    public String getHousesAsText() {
        String text = "";
        for (House house : houses)
            text += house.getHouseNo() + ", ";
        if (text.length() > 1)
            text = text.substring(0, text.length() - 2);

        return text;
    }

    public void setHousesAsText(String housesAsText) {
        if (housesAsText != null && !housesAsText.isEmpty()) {
            List<House> houseList = new ArrayList<>();
            House houseEntity;
            String[] strHouses = housesAsText.split(",");
            for (String no : strHouses) {
                no = no.trim();
                houseEntity = new House();
                houseEntity.setHouseNo(no);
                houseList.add(houseEntity);
            }
            setHouses(houseList);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MiniPop");
        sb.append(super.toString());
        sb.append(", switch_id=").append(switch_id);
        sb.append(", mac=").append(mac);
        sb.append(", address=").append(address);
        sb.append(", numberOfPorts=").append(numberOfPorts);
        sb.append(", preferredPort=").append(preferredPort);
        sb.append(", hint=").append(getNextAvailablePortHintAsNumber());
        sb.append(", reservedPorts=").append(reservedPortList);
        return sb.toString();
    }

}
