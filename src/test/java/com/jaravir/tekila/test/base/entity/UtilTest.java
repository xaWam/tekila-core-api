package com.jaravir.tekila.test.base.entity;

import com.jaravir.tekila.base.entity.Util;
import org.junit.Test;
import static org.junit.Test.*;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void testConvertFromLongToStringArray() throws Exception {
        long amount = Util.parseAmountFromStringIntoLong("4",null);
        String[] ar = Util.convertFromLongToStringArray(amount);
        assertEquals(2, ar.length);
        assertEquals("00", ar[1]);

        amount = Util.parseAmountFromStringIntoLong("4","12");
        ar = Util.convertFromLongToStringArray(amount);
        assertEquals(2, ar.length);
        assertEquals("12", ar[1]);
    }
}