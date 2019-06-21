package com.jaravir.tekila.test.module.stats.persistence.entity;

import com.jaravir.tekila.module.stats.persistence.entity.OnlineBroadbandStats;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class OnlineBroadbandStatsTest {

    @Test
    public void testGetDuration() throws Exception {
        OnlineBroadbandStats stats = new OnlineBroadbandStats();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        Date date = df.parse("00:19:00 08.01.2015");
        stats.setStartTime(date);
        String duration = stats.getDuration();
        System.out.println(duration);
        assertNotNull(duration);

    }
}