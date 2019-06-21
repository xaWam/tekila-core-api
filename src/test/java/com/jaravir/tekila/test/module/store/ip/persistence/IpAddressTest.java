package com.jaravir.tekila.test.module.store.ip.persistence;

import com.jaravir.tekila.module.store.ip.persistence.IpAddress;
import org.jboss.arquillian.container.test.api.ShouldThrowException;
import org.junit.Test;

import static org.junit.Assert.*;

public class IpAddressTest {
    @Test(expected = IllegalArgumentException.class)
    public void testCreateIllegalAddresses1() throws Exception {
        IpAddress addr = new IpAddress(255, 255, 255, 255);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalAddresses0() throws Exception {
        IpAddress addr = new IpAddress(0,0,0,0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalAddresses2() throws Exception {
        IpAddress addr = new IpAddress(0,0,0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalAddresses3() throws Exception {
        IpAddress addr = new IpAddress(192,168,0,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalAddresses4() throws Exception {
        IpAddress addr = new IpAddress(192,168,0,256);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalAddresses5() throws Exception {
        IpAddress address = new IpAddress(256, 1, 12, 13);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalAddresses6() throws Exception {
        IpAddress address = new IpAddress(11, -2, 13, 14);
    }

    @Test
    public void testGetAddressAsString() throws Exception {
        IpAddress addr = new IpAddress(192,168,1,1);
        assertEquals("192.168.1.1", addr.getAddressAsString());
    }

    @Test
    public void testSetAddressAsString() throws Exception {
        IpAddress addr = new IpAddress();
        addr.setAddressAsString("192.168.1.1");
        assertArrayEquals(new int[]{192,168,1,1}, addr.getRawAddress());
    }

    @Test
    public void testEquals() throws Exception {
        IpAddress addr = new IpAddress(192,168,1,1);
        IpAddress other = new IpAddress(192,168,1,1);
        IpAddress other_2 = new IpAddress(192,168,1,2);
        IpAddress address_2 = new IpAddress(192, 168, 2, 1);

        assertEquals(addr, other);
        assertFalse(addr.equals(other_2));
        assertFalse(address_2.equals(other_2));
    }

    @Test
    public void testCompareTo() throws Exception {
        IpAddress address = new IpAddress(192, 168, 1, 1);
        IpAddress other = new IpAddress(192, 168, 1, 1);
        IpAddress prev = new IpAddress(192, 168, 0, 1);
        IpAddress next = new IpAddress(192, 168, 1, 2);
        IpAddress address_2 = new IpAddress(192, 168, 2, 1);

        assertTrue(address.compareTo(other) == 0);
        assertTrue(address.compareTo(prev) > 0);
        assertTrue(address.compareTo(next) < 0);
        assertTrue(String.format("address_2=%d, next=%d, diff=%d", address_2.convertAddressToLong(), next.convertAddressToLong(), address_2.convertAddressToLong() - next.convertAddressToLong()), address_2.compareTo(next) > 0);
    }

    @Test
    public void testIsBefore() throws Exception {
        IpAddress address = new IpAddress(192, 168, 1, 1);
        IpAddress other = new IpAddress(192, 168, 2, 1);

        assertTrue(address.isBefore(other));
        assertTrue(other.isAfter(address));
    }

    @Test
    public void testIsBeforeOrEquals() throws Exception {
        IpAddress address = new IpAddress(192, 168, 1, 1);
        IpAddress other = new IpAddress(192, 168, 2, 1);
        IpAddress other_2 = new IpAddress(192, 168, 1, 1);

        assertTrue(address.isBeforeOrEquals(other));
        assertTrue(address.isBeforeOrEquals(other_2));
        assertTrue(other.isAfterOrEquals(address));
    }

    @Test
    public void testGetNextAddresss() throws Exception {
        IpAddress address = new IpAddress(192, 168, 1, 2);
        IpAddress other = address.getNextAddress();
        assertTrue(String.format("address=%s, other=%s", address, other), other.isAfter(address));
        assertEquals(new IpAddress(192, 168, 1, 3), other);
    }

    @Test
    public void testGetNextAddresss2() throws Exception {
        IpAddress address = new IpAddress(192, 255, 254, 254);
        IpAddress other = address.getNextAddress();
        assertTrue(String.format("address=%s, other=%s", address, other), other.isAfter(address));
        assertEquals(new IpAddress(192,255,255,254), other);
    }

    @Test
    public void testGetNextAddresss3() throws Exception {
        IpAddress address = new IpAddress(192, 255, 255, 254);
        IpAddress other = address.getNextAddress();
        assertTrue(String.format("address=%s, other=%s", address, other), other.isAfter(address));
        assertEquals(new IpAddress(193,255,255,254), other);
    }
}