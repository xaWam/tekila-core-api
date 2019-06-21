package com.jaravir.tekila.module.campaign;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.Service;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.module.service.entity.ValueAddedService;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sajabrayilov on 5/29/2015.
 */
public class Campaign extends BaseEntity {
    private List<Service> serviceList;
    private CampaignTarget target;
    private int count;
    private Double bonusCount;
    private int lifeCycleCount;
    private ServiceProvider provider;
    private CampaignStatus status;
    private String name;
    private DateTime expirationDate;
    private List<Campaign> campaignList;
    private boolean isCompound;
    private boolean isAutomatic;
    private Map<Service, Long> bonusLimits;
    private boolean isCancelInvoice;
    private boolean isActivateOnDemand;
    private boolean isActivateOnManualPaymentOnly;
    private boolean isAvailableOnCreation;
    private Double equipmentDiscount;
    private String desc;
    private List<ValueAddedService> vasList;
    private boolean isVasOnly;
    private boolean partialPromoTransfer;
    private Long promoTransferLimit;
    private DateTime bonusDate;
    private boolean corporateEnabled;
    private boolean isActivateOnPayment;

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public CampaignTarget getTarget() {
        return target;
    }

    public void setTarget(CampaignTarget target) {
        this.target = target;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getBonusCount() {
        return bonusCount;
    }

    public void setBonusCount(Double bonusCount) {
        this.bonusCount = bonusCount;
    }

    public int getLifeCycleCount() {
        return lifeCycleCount;
    }

    public void setLifeCycleCount(int lifeCycleCount) {
        this.lifeCycleCount = lifeCycleCount;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public CampaignStatus getStatus() {
        return status;
    }

    public void setStatus(CampaignStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public void setCampaignList(List<Campaign> campaignList) {
        this.campaignList = campaignList;
    }

    public boolean isCompound() {
        return isCompound;
    }

    public void setCompound(boolean isCompound) {
        this.isCompound = isCompound;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    public Map<Service, Long> getBonusLimits() {
        if (bonusLimits == null)
            bonusLimits = new HashMap<>();
        return bonusLimits;
    }

    public void setBonusLimits(Map<Service, Long> bonusLimits) {
        this.bonusLimits = bonusLimits;
    }

    public Long getBonusLimitByService (Service service) {
        return getBonusLimits().get(service);
    }

    public void addBonusLimit (Service service, Long limit) {
        if (service == null || limit == null)
            throw new IllegalArgumentException("Both service and limit must be NON-NULL values");
        getBonusLimits().put(service,limit);
    }

    public boolean isCancelInvoice() {
        return isCancelInvoice;
    }

    public void setCancelInvoice(boolean cancelInvoice) {
        this.isCancelInvoice = cancelInvoice;
    }

    public boolean isActivateOnDemand() {
        return isActivateOnDemand;
    }

    public void setActivateOnDemand(boolean isActivateOnDemand) {
        this.isActivateOnDemand = isActivateOnDemand;
    }

    public boolean isActivateOnManualPaymentOnly() {
        return isActivateOnManualPaymentOnly;
    }

    public void setActivateOnManualPaymentOnly(boolean activateOnManualPaymentOnly) {
        isActivateOnManualPaymentOnly = activateOnManualPaymentOnly;
    }

    public boolean isAvailableOnCreation() {
        return isAvailableOnCreation;
    }

    public void setAvailableOnCreation(boolean availableOnCreation) {
        isAvailableOnCreation = availableOnCreation;
    }

    public boolean isActivateOnPayment() {
        return isActivateOnPayment;
    }

    public void setActivateOnPayment(boolean activateOnPayment) {
        isActivateOnPayment = activateOnPayment;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getEquipmentDiscount() {
        return equipmentDiscount;
    }

    public void setEquipmentDiscount(Double equipmentDiscount) {
        this.equipmentDiscount = equipmentDiscount;
    }

    public List<ValueAddedService> getVasList() {
        return vasList;
    }

    public void setVasList(List<ValueAddedService> vasList) {
        this.vasList = vasList;
    }

    public boolean isVasOnly() {
        return isVasOnly;
    }

    public void setVasOnly(boolean vasOnly) {
        isVasOnly = vasOnly;
    }

    public boolean isPartialPromoTransfer() {
        return partialPromoTransfer;
    }

    public void setPartialPromoTransfer(boolean partialPromoTransfer) {
        this.partialPromoTransfer = partialPromoTransfer;
    }

    public Long getPromoTransferLimit() {
        return promoTransferLimit;
    }

    public void setPromoTransferLimit(Long promoTransferLimit) {
        this.promoTransferLimit = promoTransferLimit;
    }

    public DateTime getBonusDate() {
        return bonusDate;
    }

    public void setBonusDate(DateTime bonusDate) {
        this.bonusDate = bonusDate;
    }

    public boolean isCorporateEnabled() {
        return corporateEnabled;
    }

    public void setCorporateEnabled(boolean corporateEnabled) {
        this.corporateEnabled = corporateEnabled;
    }
}
