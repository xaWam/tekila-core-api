package com.jaravir.tekila.module.subscription.persistence.entity.history;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscriber;
import org.joda.time.DateTime;

/**
 * Created by sajabrayilov on 12/29/2014.
 */
public class SubscriberLog extends Subscriber {
    private DateTime versionClosed;
    private User user;

    public DateTime getVersionClosed() {
        return versionClosed;
    }

    public void setVersionClosed(DateTime versionClosed) {
        this.versionClosed = versionClosed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
