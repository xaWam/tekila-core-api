package com.jaravir.tekila.test.provision.broadband.devices;

import com.jaravir.tekila.provision.broadband.devices.MiniPop;
import com.jaravir.tekila.provision.broadband.devices.Port;
import com.jaravir.tekila.provision.broadband.devices.exception.NoFreePortLeftException;
import org.junit.Test;

import static org.junit.Assert.*;

public class MiniPopTest {

    @Test
    public void testReserve() throws Exception {
        MiniPop miniPop = new MiniPop();
        miniPop.setNumberOfPorts(24);

        Port port = miniPop.reserve(1);
        assertEquals(1, miniPop.getReservedPortList().size());
        assertEquals(1, port.getNumber());
        assertTrue(port.isIsOccupied());
    }

    @Test
    public void testFree() throws Exception {
        MiniPop miniPop = new MiniPop();
        miniPop.setNumberOfPorts(24);

        Port port = miniPop.reserve(1);
        miniPop.free(1);
        assertEquals(0, miniPop.getReservedPortList().size());
    }

    @Test
    public void testGetNextAvailable() throws Exception {
        MiniPop miniPop = new MiniPop();
        miniPop.setNumberOfPorts(24);

        Port port = miniPop.getNextAvailablePort();
        assertEquals(1, miniPop.getReservedPortList().size());
        assertEquals(1, port.getNumber());
        assertTrue(port.isIsOccupied());

        Port port2 = miniPop.getNextAvailablePort();
        assertEquals(2, miniPop.getReservedPortList().size());
        assertEquals(2, port2.getNumber());
        assertTrue(port2.isIsOccupied());

        miniPop.free(1);

        assertEquals(1, miniPop.getReservedPortList().size());

        Port port3 = miniPop.getNextAvailablePort();
        assertEquals(1, port3.getNumber());
        assertTrue(port3.isIsOccupied());
        assertEquals(2, miniPop.getReservedPortList().size());
    }

    @Test(expected = NoFreePortLeftException.class)
    public void testGetNextAvailableNoPortsLeft() throws NoFreePortLeftException {
        MiniPop miniPop = new MiniPop();
        miniPop.setNumberOfPorts(24);

        for (int i = 1; i <= miniPop.getNumberOfPorts(); i++) {
            miniPop.getNextAvailablePort();
        }
        assertEquals(24, miniPop.getReservedPortList().size());
        Port port = miniPop.getNextAvailablePort();

       assertNull(port);
    }

    @Test
    public void testGetReservedPortsAsText() throws NoFreePortLeftException {
        MiniPop miniPop = new MiniPop();
        miniPop.setNumberOfPorts(24);

        miniPop.getNextAvailablePort();
        miniPop.getNextAvailablePort();

        System.out.println("Reserved list: " + miniPop.getReservedPortsAsText());

        assertNotSame(miniPop.getReservedPortsAsText(), "-", miniPop.getReservedPortsAsText());
    }

    @Test
    public void testGetAvailablePortsAsText() throws NoFreePortLeftException {
        MiniPop miniPop = new MiniPop();
        miniPop.setNumberOfPorts(24);

        miniPop.getNextAvailablePort();
        miniPop.getNextAvailablePort();

        assertNotSame(miniPop.getAvailablePortsAsText(), "-", miniPop.getAvailablePortsAsText());
    }

    @Test
    public void testGetNextAvailablePortHint() throws NoFreePortLeftException {
        MiniPop miniPop = new MiniPop();
        miniPop.setNumberOfPorts(24);

        miniPop.getNextAvailablePort();
        miniPop.getNextAvailablePort();

        Port port = miniPop.getNextAvailablePortHint();
        System.out.println(port);
        assertNotNull(port);
        assertEquals(3, port.getNumber());
    }
}