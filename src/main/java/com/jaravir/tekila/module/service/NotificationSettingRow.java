package com.jaravir.tekila.module.service;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.event.BillingEvent;
import com.jaravir.tekila.module.event.notification.channell.NotificationChannell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajabrayilov on 12/24/2014.
 */
public class NotificationSettingRow implements Serializable {
    private BillingEvent event;
    private List<NotificationChannell> channelList;
    private List<String> selectedChannelList;

    public NotificationSettingRow() {}

    public NotificationSettingRow(BillingEvent event, List<NotificationChannell> channelList) {
        this.event = event;
        this.channelList = channelList;
    }

    public NotificationSettingRow(BillingEvent event, NotificationChannell[] channelList) {
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

    public List<String> getSelectedChannelList() {
        return selectedChannelList;
    }

    public void setSelectedChannelList(List<String> selectedChannelList) {
        this.selectedChannelList = selectedChannelList;
    }

    public List<NotificationChannell> getSelectedChannelListAsChannels() {
        if (selectedChannelList == null || selectedChannelList.isEmpty())
            return null;

        List<NotificationChannell> selectedChannels = new ArrayList<>();

        for (String chan : selectedChannelList)
            selectedChannels.add(NotificationChannell.convertFromCode(chan));

        return selectedChannels;
    }

    public void setSelectedChannelListAsChannels (List<NotificationChannell> channels) {
        if (channels == null || channels.isEmpty())
            return;

        selectedChannelList = new ArrayList<>();

        for (NotificationChannell chan : channels)
            selectedChannelList.add(chan.getCode());

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationSetting{");
        sb.append(super.toString());
        sb.append(", event=").append(event);
        sb.append(", channelList=").append(channelList);
        sb.append(", selectedChannelList=").append(selectedChannelList);
        sb.append('}');
        return sb.toString();
    }
}
