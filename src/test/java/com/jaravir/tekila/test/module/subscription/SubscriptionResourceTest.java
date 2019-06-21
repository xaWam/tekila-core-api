package com.jaravir.tekila.test.module.subscription;

import com.jaravir.tekila.module.service.ResourceBucketType;
import com.jaravir.tekila.module.service.entity.ResourceBucket;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;
import com.jaravir.tekila.module.subscription.persistence.entity.SubscriptionResource;
import com.jaravir.tekila.module.subscription.persistence.entity.SubscriptionResourceBucket;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by sajabrayilov on 7/22/2015.
 */
public class SubscriptionResourceTest {
    private static Subscription subscription;

    @BeforeClass
    public static void before () {
        subscription = new Subscription();
    }

    @Ignore
    @Test
    public void testOneResource () {
        SubscriptionResource resource = new SubscriptionResource();
        subscription.addResource(resource);

        assertNotNull(subscription.getActiveResource());
    }

    @Ignore
    @Test
    public void testActiveResourceWhenMultiple() {
        SubscriptionResource resource = new SubscriptionResource();
        resource.setId(1);
        resource.setActivationDate(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2015-05-22 23:59:59"));
        resource.setExpirationDate(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2015-07-21 23:59:59"));

        SubscriptionResource resource_expired = new SubscriptionResource();
        resource_expired.setId(2);
        resource_expired.setActivationDate(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2015-07-21 23:59:59"));
        resource_expired.setExpirationDate(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2015-09-22 23:59:59"));

        subscription.addResource(resource_expired);
        subscription.addResource(resource);

        SubscriptionResource activeResource = subscription.getActiveResource();
        assertNotNull(activeResource);
        assertEquals(2, activeResource.getId());
        assertTrue(activeResource.getExpirationDate().isAfter(DateTime.now()));
    }

    @Test
    public void testSetResourceBucketCapacityByType () {
        SubscriptionResource resource = new SubscriptionResource();
        subscription.addResource(resource);
        subscription.setBucketCapacityByType(ResourceBucketType.INTERNET_DOWN, "20");

        SubscriptionResourceBucket resourceBucket = new SubscriptionResourceBucket();
        resourceBucket.setType(ResourceBucketType.INTERNET_DOWN);
        resourceBucket.setCapacity("10");
        resource.addBucket(resourceBucket);

        assertEquals("10", subscription.sgetBucketCapacityByType(ResourceBucketType.INTERNET_DOWN));

        subscription.setBucketCapacityByType(ResourceBucketType.INTERNET_DOWN, "20");
        assertEquals("20", subscription.sgetBucketCapacityByType(ResourceBucketType.INTERNET_DOWN));

        SubscriptionResourceBucket resourceBucket_2 = new SubscriptionResourceBucket();
        resourceBucket_2.setType(ResourceBucketType.INTERNET_UP);
        resourceBucket_2.setCapacity("10");
        resource.addBucket(resourceBucket_2);

        assertEquals("10", subscription.sgetBucketCapacityByType(ResourceBucketType.INTERNET_UP));

        subscription.setBucketCapacityByType(ResourceBucketType.INTERNET_UP, "30");
        assertEquals("30", subscription.sgetBucketCapacityByType(ResourceBucketType.INTERNET_UP));
    }
}
