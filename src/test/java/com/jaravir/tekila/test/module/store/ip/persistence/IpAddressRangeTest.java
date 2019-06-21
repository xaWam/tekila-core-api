package com.jaravir.tekila.test.module.store.ip.persistence;

import com.jaravir.tekila.module.store.ip.IpAddressStatus;
import com.jaravir.tekila.module.store.ip.exception.IpAddressRangeOutOfBoundsException;
import com.jaravir.tekila.module.store.ip.persistence.IpAddress;
import com.jaravir.tekila.module.store.ip.persistence.IpAddressRange;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IpAddressRangeTest {
    private static IpAddressRange range;

    @Before
    public void initRange() {
        range = new IpAddressRange(new IpAddress(192, 168,1,1), new IpAddress(192, 168, 1, 254));
    }

    @Test
    public void testInsideRange() {
        assertTrue(range.isInsideRange(new IpAddress(192, 168, 1, 3)));
        assertTrue(range.isInsideRange(new IpAddress(192, 168, 1, 1)));
        assertTrue(range.isInsideRange(new IpAddress(192, 168, 1, 254)));
        assertFalse(range.isInsideRange(new IpAddress(192, 168, 0, 3)));
    }

    @Test
    public void testReserveAddress() throws Exception {
        IpAddress address = new IpAddress(192,168,1,5);
        range.reserveAddress(address);

        assertTrue(address.isReserved());
        assertEquals(IpAddressStatus.RESERVED, address.getStatus());
        assertTrue(range.getReservedAddressList().size() == 1);
    }

    @Test
    public void testReserveOutOfRangeAddress() throws Exception {
        IpAddress address = new IpAddress(192, 168, 0, 5);
        range.reserveAddress(address);

        assertFalse(address.isReserved());
        assertFalse(address.getStatus() == IpAddressStatus.RESERVED);
        assertTrue(range.getReservedAddressList().isEmpty());
    }

    @Test
    public void testFreeAddress() throws Exception {
        IpAddress address = new IpAddress(192, 168, 1, 5);
        range.reserveAddress(address);

        assertEquals(IpAddressStatus.RESERVED, address.getStatus());
        assertFalse(range.getReservedAddressList().isEmpty());

        range.freeAddress(address);

        assertFalse(address.getStatus() == IpAddressStatus.RESERVED);
        assertEquals(IpAddressStatus.AVAILABLE, address.getStatus());
        assertTrue(range.getReservedAddressList().isEmpty());
    }

    @Test
    public void testFindAndReserveFreeAddress() throws Exception {
        IpAddress ipAddress = range.findAndReserveFreeAddress();
        IpAddress other = new IpAddress(192,168,1,1);
        other.setStatus(IpAddressStatus.RESERVED);

        assertEquals(IpAddressStatus.RESERVED, ipAddress.getStatus());
        assertEquals(other, ipAddress);
        assertTrue(range.getReservedAddressList().size() == 1);

        IpAddress ipAddress_2 = range.findAndReserveFreeAddress();
        IpAddress other_2 = new IpAddress(192, 168,1,2);
        other_2.setStatus(IpAddressStatus.RESERVED);

        assertEquals(IpAddressStatus.RESERVED, ipAddress_2.getStatus());
        assertEquals(other_2, ipAddress_2);
        assertTrue(range.getReservedAddressList().size() == 2);
    }

    @Test(expected = IpAddressRangeOutOfBoundsException.class)
    public void testFindAndReserveFreeAddressFullRange() throws Exception {
        List<IpAddress> addressList = new ArrayList<>();

        for (int i = 1; i < 255; i++) {
            addressList.add(new IpAddress(192, 168, 1, i));
        }

        range.setReservedAddressList(addressList);

        assertTrue(range.getReservedAddressList().size() == 254);

        IpAddress address = range.findAndReserveFreeAddress();
    }

    @Test
    public void testFreeOutOfRange() throws Exception {
        IpAddress address = new IpAddress(192, 168, 0, 2);
        address.reserve();

        range.freeAddress(address);

        assertEquals(IpAddressStatus.RESERVED, address.getStatus());
    }
}