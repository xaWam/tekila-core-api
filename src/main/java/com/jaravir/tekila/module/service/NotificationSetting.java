package com.jaravir.tekila.module.service;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.event.BillingEvent;
import com.jaravir.tekila.module.event.notification.channell.NotificationChannell;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by sajabrayilov on 12/24/2014.
 */
public class NotificationSetting extends BaseEntity {
    private BillingEvent event;
    private List<NotificationChannell> channelList;

    public NotificationSetting() {
    }

    public NotificationSetting(BillingEvent event, List<NotificationChannell> channelList) {
        this.event = event;
        this.channelList = channelList;
    }

    public NotificationSetting(BillingEvent event, NotificationChannell[] channelList) {
        this.event = event;
        this.channelList = new ArrayList<>();

        for (int i = 0; i < channelList.length; i++)
            this.channelList.add(channelList[i]);
    }

    public BillingEvent getEvent() {
        return event;
    }

    public void setEvent(BillingEvent event) {
        this.event = event;
    }

    public List<NotificationChannell> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<NotificationChannell> channelList) {
        this.channelList = channelList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotificationSetting)) return false;
        NotificationSetting setting = (NotificationSetting) o;
        return event == setting.event && id == setting.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), event, id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationSetting{");
        sb.append(super.toString());
        sb.append(", event=").append(event);
        sb.append(", channelList=").append(channelList);
        sb.append('}');
        return sb.toString();
    }
}
