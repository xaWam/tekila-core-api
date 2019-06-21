package com.jaravir.tekila.module.store.ip.persistence;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.store.ip.IpAddressStatus;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by sajabrayilov on 11/14/2014.
 */
public class IpAddress extends BaseEntity implements Comparable<IpAddress>{
    private int[] address;
    private IpAddressStatus status;

    public IpAddress() {
        status = IpAddressStatus.AVAILABLE;
    }

    public IpAddress (int... addressBits) {
        this();
        check(addressBits);
        address = new int[]{addressBits[0], addressBits[1], addressBits[2], addressBits[3]};
    }

    public int[] getRawAddress() {
        return Arrays.copyOf(address, address.length);
    }

    public void setRawAddress(int[] address) {
        if (address.length != 4)
            throw new IllegalArgumentException(String.format("4 octets expected, %d received", address.length));

        this.address = address;
    }

    public String getAddressAsString() {

        if (address == null)
            address = new int[4];

//        StringBuilder sb = new StringBuilder();

//        for (int i = 0; i < address.length; i++) {
//            sb.append(address[i]);
//            if (i < (address.length - 1))
//                sb.append('.');
//        }
//        return sb.toString();

        String ip = Arrays.stream(address)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("."));

        return ip;
    }

    public void setAddressAsString (String address) {
        String[] tempAddr = address.split("\\.");
        if (tempAddr.length != 4)
            throw new IllegalArgumentException(String.format("Cannot parse %s. 4 octets expected, %d provided", address, tempAddr.length));

        int[] tempIntaddress = new int[4];

        for (int i = 0; i < tempAddr.length; i++) {
            tempIntaddress[i] = Integer.parseInt(tempAddr[i]);
        }

        check(tempIntaddress);
        this.address = tempIntaddress;
    }

    public IpAddressStatus getStatus() {
        return status;
    }

    public void setStatus(IpAddressStatus status) {
        this.status = status;
    }

    public long convertAddressToLong() {
        long sum = 0;

        for (int i = 0; i < address.length; i++)
            sum += address[i] * Math.pow(10, address.length - i);

        return sum;
    }

    public void free() {
        status = IpAddressStatus.AVAILABLE;
    }

    public void reserve() {
        status = IpAddressStatus.RESERVED;
    }

    @Override
    public int compareTo (IpAddress addr) {
        /*long res = convertAddressToLong() - addr.convertAddressToLong();

        if (res > 0)
            return 1;
        if (res < 0)
            return -1;
        else
            return 0;
        */
        return hashCode() - addr.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;

        IpAddress ipAddress = (IpAddress) o;
        //System.out.println(String.format("equlas: this=%s, this long=%d, object=%s, object long=%d", this.getAddressAsString(), this.convertAddressToLong(), ipAddress.getAddressAsString(), ipAddress.convertAddressToLong()));
        //if (!Arrays.equals(address, ipAddress.address)) return false;
        return convertAddressToLong() == ipAddress.convertAddressToLong();
        /*if (status != ipAddress.status)
            return false;
        */
    }

    public boolean isBefore (IpAddress addr) {
        return (compareTo(addr) < 0) ? true : false;
    }

    public boolean isBeforeOrEquals (IpAddress addr) {
        return compareTo(addr) <= 0;
    }

    public boolean isAfter (IpAddress addr) {
        return compareTo(addr) > 0;
    }

    public boolean isAfterOrEquals (IpAddress address) {
        return compareTo(address) >= 0;
    }

    public IpAddress getNextAddress () {
        return incrementAddressByOne();
    }

    private void check(int[] addr) {
        if (addr.length != 4)
            throw new IllegalArgumentException(String.format("There have to be 4 octets, %d provided", addr.length));

        for (int i = 0; i < addr.length; i++)
            if (addr[i] < 0 || addr[i] > 255)
                throw new IllegalArgumentException("Numbers should be between 0 and 255");

        if (addr[0] == 0 && addr[1] == 0 && addr[2] == 0 && addr[3] == 0)
            throw new IllegalArgumentException("0.0.0.0 is illegal address");

        if (addr[0] == 255 && addr[1] == 255 && addr[2] == 255 && addr[3] == 255)
            throw new IllegalArgumentException("255.255.255.255 is illegal address");

//        if (addr[3] == 0 || addr[3] == 255)
//            throw new IllegalArgumentException(String.format("%d.%d.%d.%d is illegal address", addr[0],addr[1],addr[2],addr[3]));
    }
    private IpAddress incrementAddressByOne () {
        int[] newRawAddress = getRawAddress();
        int residual = 1;

        for (int i = newRawAddress.length - 1; i >= 0; i--) {
            //newRawAddress[i] += residual;
            if ((i == 3 && newRawAddress[i] == 254) || newRawAddress[i] >= 255) {
                continue;
            }
            else {
                newRawAddress[i] += residual;
                break;
            }
        }
        return new IpAddress (newRawAddress);
    }

    public boolean isValid ()  {
        try {
            check(address);
            return true;
        }
        catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public boolean isFree () {
        return status == IpAddressStatus.AVAILABLE;
    }

    public boolean isReserved() {
        return status == IpAddressStatus.RESERVED;
    }

    @Override
    public int hashCode() {
        //int result = super.hashCode();
        //result = 31 * result + (address != null ? Arrays.hashCode(address) : 0);
        //result = 31 * result + (status != null ? status.hashCode() : 0);
        //return result;

        return address != null ? Arrays.hashCode(address) : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("IpAddress{");
        sb.append(super.toString());
        sb.append(", address=").append(this.getAddressAsString());
        sb.append(", status=").append(status);
        return sb.append('}').toString();
    }
}
