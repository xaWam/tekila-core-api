package com.jaravir.tekila.module.periodic;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajabrayilov on 5/4/2015.
 */
public class Job extends BaseEntity {
    private DateTime startTime;
    private DateTime deadline;
    private JobCategory category;
    private List<JobProperty> propertyList;
    private User user;
    private JobStatus status;
    private boolean counter;

    public Job () {
        propertyList = new ArrayList<>();
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(DateTime deadline) {
        this.deadline = deadline;
    }

    public List<JobProperty> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<JobProperty> propertyList) {
        this.propertyList = propertyList;
    }

    public boolean addProperty (JobProperty property) {
        return propertyList.add(property);
    }

    public boolean removeProperty (JobProperty property) {
        return propertyList.remove(property);
    }

    public JobProperty findPropertyByType (JobPropertyType type) {
        if (propertyList.size() > 0) {
            for (JobProperty property : propertyList) {
                if (property.getType() == type) {
                    return property;
                }
            }
        }
        return null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JobCategory getCategory() {
        return category;
    }

    public void setCategory(JobCategory category) {
        this.category = category;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public boolean isCounter() {
        return counter;
    }

    public void setCounter(boolean counter) {
        this.counter = counter;
    }
}
