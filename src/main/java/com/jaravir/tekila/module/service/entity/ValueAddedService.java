/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.service.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.accounting.entity.TaxationCategory;
import com.jaravir.tekila.module.service.ServiceType;
import com.jaravir.tekila.module.service.VASSetting;
import com.jaravir.tekila.module.service.ValueAddedServiceType;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jaravir.tekila.module.store.ip.StaticIPType;
import org.joda.time.DateTime;

import javax.annotation.PostConstruct;

/**
 * @author sajabrayilov
 */
public class ValueAddedService extends BaseEntity {
    private String name;
    private VASCode code;
    private Resource resource;
    private TaxationCategory category;
    private boolean isManagedByPrincipal;
    private ServiceProvider provider;
    private long price;
    private Date creationDate;
    private List<VASSetting> settings;
    private String expression;
    private String chargeableItem;
    private boolean provisioned;
    private long maxNumber;
    private double count = -1;
    private boolean isActive;
    private boolean isStaticIp;
    private boolean doPartialCharge;
    private StaticIPType staticIPType;
    private boolean credit;
    private boolean suspension;
    private String alternateName;
    private boolean isIptv;
    private boolean isSip;

    public boolean isManagedByPrincipal() {
        return isManagedByPrincipal;
    }

    public void setManagedByPrincipal(boolean managedByPrincipal) {
        isManagedByPrincipal = managedByPrincipal;
    }

    public StaticIPType getStaticIPType() {
        return staticIPType;
    }

    public void setStaticIPType(StaticIPType staticIPType) {
        this.staticIPType = staticIPType;
    }

    public boolean isDoPartialCharge() {
        return doPartialCharge;
    }

    public void setDoPartialCharge(boolean doPartialCharge) {
        this.doPartialCharge = doPartialCharge;
    }

    public boolean isStaticIp() {
        return isStaticIp;
    }

    public void setStaticIp(boolean staticIp) {
        isStaticIp = staticIp;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) { this.count = count; }

    public ValueAddedService() {
        maxNumber = -1;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public TaxationCategory getCategory() {
        return category;
    }

    public void setCategory(TaxationCategory category) {
        this.category = category;
    }

    public boolean isIsManagedByPrincipal() {
        return isManagedByPrincipal;
    }

    public void setIsManagedByPrincipal(boolean isManagedByPrincipal) {
        this.isManagedByPrincipal = isManagedByPrincipal;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VASCode getCode() {
        return code;
    }

    public void setCode(VASCode code) {
        this.code = code;
    }



    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<VASSetting> getSettings() {
        if (settings == null)
            settings = new ArrayList<>();
        return settings;
    }

    public void addSetting(String name, String dsc) {
        addSetting(new VASSetting(name, dsc));
    }

    public void addSetting(VASSetting setting) {
        getSettings().add(setting);
    }

    public void setSettings(List<VASSetting> settings) {
        this.settings = settings;
    }

    public void removeSetting(VASSetting setting) {
        if (getSettings().contains(setting))
            getSettings().remove(setting);
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public VASSetting getSettingByName(String name) {
        if (!settings.isEmpty())
            for (int i = 0; i < settings.size(); i++) {
                if (settings.get(i).getName().equals(name))
                    return settings.get(i);
            }

        return null;
    }

    public String getChargeableItem() {
        return chargeableItem;
    }

    public void setChargeableItem(String chargeableItem) {
        this.chargeableItem = chargeableItem;
    }

    public boolean isProvisioned() {
        return provisioned;
    }

    public void setProvisioned(boolean provisioned) {
        this.provisioned = provisioned;
    }

    public long getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(long maxNumber) {
        this.maxNumber = maxNumber;
    }

    public boolean isCredit() {
        return credit;
    }

    public void setCredit(boolean credit) {
        this.credit = credit;
    }

    public boolean isSuspension() {
        return suspension;
    }

    public void setSuspension(boolean suspension) {
        this.suspension = suspension;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    public boolean isIptv() {
        return isIptv;
    }

    public void setIptv(boolean iptv) {
        isIptv = iptv;
    }

    public boolean isSip() {
        return isSip;
    }

    public void setSip(boolean sip) {
        isSip = sip;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getPriceInDouble(){
        double val = this.price / 100000D;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return Double.parseDouble(decimalFormat.format(val));
    }
    public void setPriceInDouble(double price){this.price = Double.valueOf(price*100000).longValue();}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ValueAddedService{");
        sb.append(super.toString());
        sb.append(", name=").append(name)
                .append(", code=").append(code)
                .append(", resource=").append(resource)
                .append(", category=").append(category)
                .append(", isManagedByPrincipal=").append(isManagedByPrincipal)
                .append(", provider=").append(provider)
                .append(", price=").append(price).append('}');
        return sb.toString();
    }
}
