package com.jaravir.tekila.module.store;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChargeItemRegisterTest {

    @Test
    public void testGetMappedClass() throws Exception {
        ChargeItemRegister register = ChargeItemRegister.getInstance();
        assertNotNull(register.getMappedClass("msisdn"));
    }
}