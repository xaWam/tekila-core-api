package com.jaravir.tekila.module.service.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import org.joda.time.DateTime;

/**
 * Created by shnovruzov on 6/30/2016.
 */
public class ServiceProfile extends BaseEntity{

    private Integer period;
    private Double up;
    private Double down;
    private String from;
    private String to;
    private Service service;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Double getDown() {
        return down;
    }

    public void setDown(Double down) {
        this.down = down;
    }

    public Double getUp() {
        return up;
    }

    public void setUp(Double up) {
        this.up = up;
    }
}
