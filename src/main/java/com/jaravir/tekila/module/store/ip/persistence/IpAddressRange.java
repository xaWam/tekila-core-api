package com.jaravir.tekila.module.store.ip.persistence;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.store.ip.IpAddressStatus;
import com.jaravir.tekila.module.store.ip.exception.IpAddressRangeOutOfBoundsException;
import com.jaravir.tekila.module.store.nas.Nas;

import java.util.*;

/**
 * Created by sajabrayilov on 11/14/2014.
 */
public class IpAddressRange extends BaseEntity {
    private IpAddress start;
    private IpAddress end;
    private String mask;
    private List<IpAddress> reservedAddressList;
    private final static String defaultMask;
    private Nas nas;

    static {
        defaultMask = "255.255.255.0";
    }


    public Nas getNas() {
        return nas;
    }

    public void setNas(Nas nas) {
        this.nas = nas;
    }

    public IpAddressRange() {
        this(null, null, defaultMask);
    }

    public IpAddressRange(IpAddress start, IpAddress end) {
        this.start = start;
        this.end = end;
    }

    public IpAddressRange(IpAddress start, IpAddress end, Nas nas) {
        this.start = start;
        this.end = end;
        this.nas = nas;
    }

    public IpAddressRange(IpAddress start, IpAddress end, String mask) {
        this.start = start;
        this.end = end;
        this.mask = mask;
    }

    public IpAddress getStart() {
        return start;
    }

    public void setStart(IpAddress start) {
        this.start = start;
    }

    public IpAddress getEnd() {
        return end;
    }

    public void setEnd(IpAddress end) {
        this.end = end;
    }

    public List<IpAddress> getReservedAddressList() {
        if (reservedAddressList == null)
            reservedAddressList = new ArrayList<>();
        return reservedAddressList;
    }

    public void setReservedAddressList(List<IpAddress> addressList) {
        if (addressList == null || addressList.isEmpty())
            return;

        if (isInsideRange(addressList)) {
            reserveAddressList(addressList);
        }
    }

    public void reserveAddress(IpAddress address) {
        if (isInsideRange(address)) {
            address.reserve();
            getReservedAddressList().add(address);
        }
    }

    private void reserveAddressList(List<IpAddress> addressList) {
        if (addressList != null && !addressList.isEmpty())
            for (IpAddress addr : addressList)
                reserveAddress(addr);
    }

    public boolean freeAddress(IpAddress address) {
        if (!isInsideRange(address))
            return false;

        if (getReservedAddressList().contains(address)) {
            getReservedAddressList().remove(address);
            if (address.isReserved())
                address.free();
            return true;
        }

        return false;
    }

    public List<IpAddress> findFreeAddresses() {
        IpAddress current = start;
        IpAddress reserved = null;

        List<IpAddress> reservedList = new ArrayList<>(new LinkedHashSet(reservedAddressList));
        List<IpAddress> freeList = new ArrayList<>();

        while (current.compareTo(end) < 1) {
            if(!reservedList.contains(current))
                freeList.add(current);
            current = current.getNextAddress();
        }

        if(!freeList.contains(end))
            freeList.add(end);
        return freeList;
    }

    public IpAddress findAndReserveFreeAddress() throws IpAddressRangeOutOfBoundsException {
        if (reservedAddressList == null || reservedAddressList.isEmpty()) {
            reserveAddress(start);
            return start;
        }

        IpAddress current = start;
        IpAddress reserved = null;

        List<IpAddress> sortedList = new ArrayList<>(new LinkedHashSet(reservedAddressList));
        Collections.sort(sortedList);

        System.out.println("findNext: sortedList=" + sortedList);

        Iterator<IpAddress> reservedIterator = sortedList.iterator();

        reserved = reservedIterator.next();

        while (current.equals(reserved)) {
            current = current.getNextAddress();

            if (current.isAfter(end))
                throw new IpAddressRangeOutOfBoundsException(String.format("No address available in the range %s - %s", start, end));

            if (!reservedIterator.hasNext())
                break;

            reserved = reservedIterator.next();
            System.out.println(String.format("findNext: Current=%s, reserved=%s", current.getAddressAsString(), reserved.getAddressAsString()));
        }

        reserveAddress(current);

        return current;
    }

    public long calculateGap(IpAddress addr1, IpAddress addr2) {
        return addr1.convertAddressToLong() - addr2.convertAddressToLong();
    }

    public boolean isInsideRange(IpAddress address) {
        return (address.isAfterOrEquals(start) && address.isBeforeOrEquals(end));
    }

    public boolean isInsideRange(List<IpAddress> addressList) {
        if (addressList == null || addressList.isEmpty())
            return false;

        List<IpAddress> sortedList = new ArrayList<>(addressList);
        Collections.sort(sortedList);

        return sortedList.get(0).isAfterOrEquals(start) && sortedList.get(sortedList.size() - 1).isBeforeOrEquals(end);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Range{");
        sb.append(super.toString());
        sb.append(", start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", reserved=").append(reservedAddressList);
        return sb.append('}').toString();
    }
}
