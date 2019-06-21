package com.jaravir.tekila.module.sales.persistence.entity;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.accounting.entity.SalesPartnerInvoice;
import com.jaravir.tekila.module.sales.SalesPartnerSetting;
import com.jaravir.tekila.module.sales.SalesPartnerType;
import com.jaravir.tekila.module.store.SalesPartnerStore;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sajabrayilov on 11/24/2015.
 */
public class SalesPartner extends BaseEntity implements Serializable {
    private String name;
    private SalesPartnerType type;
    private Map<SalesPartnerSetting, String> settingsMap;
    private SalesPartner principal;
    private List<SalesPartner> partnerList;
    private List<SalesPartnerStore> storeList;
    private List<SalesPartnerInvoice> invoiceList;
    private User partnerUser;
    private User user;
    private DateTime creationDate;
    private String desc;

    public SalesPartner() {
        this.settingsMap = new LinkedHashMap<>();
        this.partnerList = new ArrayList<>();
        this.storeList = new ArrayList<>();
        this.invoiceList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SalesPartnerType getType() {
        return type;
    }

    public void setType(SalesPartnerType type) {
        this.type = type;
    }

    public Map<SalesPartnerSetting, String> getSettingsMap() {
        return settingsMap;
    }

    public void setSettingsMap(Map<SalesPartnerSetting, String> settingsMap) {
        this.settingsMap = settingsMap;
    }

    public List<SalesPartner> getPartnerList() {
        return partnerList;
    }

    public void setPartnerList(List<SalesPartner> partnerList) {
        this.partnerList = partnerList;
    }

    public List<SalesPartnerStore> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<SalesPartnerStore> storeList) {
        this.storeList = storeList;
    }

    public List<SalesPartnerInvoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<SalesPartnerInvoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DateTime getCreationdDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime createdDate) {
        this.creationDate = createdDate;
    }

    public void addSetting (SalesPartnerSetting setting, String value) {
        settingsMap.put(setting, value);
    }

    public void addPartner (SalesPartner partner) {
        partnerList.add(partner);
    }

    public void addInvoice (SalesPartnerInvoice invoice) {
        invoiceList.add(invoice);
    }

    public void addStore (SalesPartnerStore store) {
        storeList.add(store);
    }

    public User getPartnerUser() {
        return partnerUser;
    }

    public void setPartnerUser(User partnerUser) {
        this.partnerUser = partnerUser;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String dsc) {
        this.desc = dsc;
    }

    public SalesPartner getPrincipal() {
        return principal;
    }

    public void setPrincipal(SalesPartner principal) {
        this.principal = principal;
    }
}
