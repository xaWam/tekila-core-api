package com.jaravir.tekila.module.store.mobile;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.module.store.status.StoreItemStatus;

/**
 * Created by sajabrayilov on 13.03.2015.
 */
public class Imsi extends BaseEntity {
    private String iccid;
    private String identifier;
    private Msisdn msisdn;
    private MobileCategory category;
    private StoreItemStatus status;
    private User user;
    private ServiceProvider provider;

    public Imsi() {}

    public Imsi (String iccid, String imsi) {
        if (iccid == null || iccid.isEmpty() || imsi == null || imsi.isEmpty())
            throw new IllegalArgumentException("All parameters are required and not should not be empty");

        this.iccid = iccid;
        this.identifier = identifier;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Msisdn getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Msisdn msisdn) {
        this.msisdn = msisdn;
    }

    public MobileCategory getCategory() {
        return category;
    }

    public void setCategory(MobileCategory category) {
        this.category = category;
    }

    public StoreItemStatus getStatus() {
        return status;
    }

    public void setStatus(StoreItemStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }
}
