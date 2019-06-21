package com.jaravir.tekila.test.base.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaravir.tekila.module.service.entity.Service;
import com.jaravir.tekila.module.service.entity.ServiceGroup;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

public class ServiceSerializationTest {

    @Ignore
    @Test
    public void testSerialization() throws JsonProcessingException {
        Service testService = new Service();
        ServiceGroup testGroup = new ServiceGroup();

        testService.setGroup(testGroup);
        testService.setName("test_service");
        testGroup.setServices(Arrays.asList(testService));

        String result = new ObjectMapper().writeValueAsString(testService);
        Assert.assertThat(result, contains("test_service"));
    }

    private static Matcher<String> contains(final String contained) {
        return new Matcher<String>() {
            @Override
            public boolean matches(Object o) {
                return ((String)o).contains(contained);
            }

            @Override
            public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {

            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }
}
