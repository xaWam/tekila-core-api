package com.jaravir.tekila.module.event.notification.channell;

import com.jaravir.tekila.base.entity.BaseEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by kmaharov on 12.07.2016.
 */
public class NotificationChannelStatus extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private NotificationChannell channell;
    private boolean active;

    public NotificationChannelStatus() {
    }

    public NotificationChannell getChannell() {
        return channell;
    }

    public void setChannell(NotificationChannell channell) {
        this.channell = channell;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
