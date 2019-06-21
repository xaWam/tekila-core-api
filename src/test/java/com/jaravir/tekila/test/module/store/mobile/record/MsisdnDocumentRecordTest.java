package com.jaravir.tekila.test.module.store.mobile.record;

import com.jaravir.tekila.module.store.mobile.MobileCategory;
import com.jaravir.tekila.module.store.mobile.Msisdn;
import com.jaravir.tekila.module.store.mobile.record.MsisdnDocumentRecord;
import org.junit.Test;

import static org.junit.Assert.*;

public class MsisdnDocumentRecordTest {

    @Test
    public void testGetMsisdn() throws Exception {
        MsisdnDocumentRecord record = new MsisdnDocumentRecord("12707", MobileCategory.TEST.getPosition());
        record.setPrice(4.21d);
        record.setCommercialCategory(1L);
        record.setProvider(101L);

        Msisdn msisdn = record.getMsisdn();
        Long price = msisdn.getPrice();
        assertEquals(421000, price.longValue());
    }
}