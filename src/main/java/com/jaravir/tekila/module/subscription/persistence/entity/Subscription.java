package com.jaravir.tekila.module.subscription.persistence.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.jsonview.JsonViews;
import com.jaravir.tekila.module.campaign.CampaignRegister;
import com.jaravir.tekila.module.campaign.CampaignStatus;
import com.jaravir.tekila.module.event.BillingEvent;
import com.jaravir.tekila.module.service.*;
import com.jaravir.tekila.module.service.entity.*;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.jaravir.tekila.module.service.model.BillingModel;
import com.jaravir.tekila.module.subscription.persistence.entity.external.TechnicalStatus;
import com.jaravir.tekila.module.subscription.persistence.entity.transition.StatusChangeRule;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class Subscription extends BaseEntity implements Serializable {
    private User user;
    private Service service;
    private Balance balance;
    private String agreement;
    private String identifier;
    @JsonView(JsonViews.Subscription.class)
    private Subscriber subscriber;
    private SubscriptionStatus status;
    private SubscriptionDetails details;
    private List<SubscriptionResource> resources;
    private SubscriptionType type;
    private DateTime expirationDate;
    private Date creationDate;
    private DateTime lastStatusChangeDate;
    private DateTime lastPaymentDate;
    private List<SubscriptionVAS> vasList;
    private DateTime billedUpToDate;
    private DateTime lastBilledDate;
    private DateTime expirationDateWithGracePeriod;
    private DateTime activationDate;
    private List<SubscriptionSetting> settings;
    private boolean isDetailsIdentToSubscriber = false;
    private static final long serialVersionUID = 1L;
    private List<NotificationSetting> notificationSettings;
    private TechnicalStatus technicalStatus; //transient
    private Contract contract;
    private Map<Long, Long> defaultVasCharges;
    private long installationFee;
    private long serviceFeeRate;
    private List<Compensation> compensationList;
    private BillingModel billingModel;
    private List<CampaignRegister> campaignRegisters;
    private SubscriptionRuntimeDetails runtimeDetails;
    private boolean restoredFromFinal;
    private DateTime restorationDate;
    private boolean isDiscountEnabled;
    private boolean isTaxFreeEnabled;
    private long discountPercentage;
    private List<CampaignRegister> activeCampaigns; //transient
    private String activeCampaignsStr; //transient
    private PaymentTypes paymentType;
    private boolean isIptvOwner;
    private Long speed; //transient

    public List<Compensation> getCompensationList() {
        return compensationList;
    }

    public void setCompensationList(List<Compensation> compensationList) {
        this.compensationList = compensationList;
    }

    public Subscription() {
        this.resources = new ArrayList<SubscriptionResource>();
        this.settings = new ArrayList<SubscriptionSetting>();
    }

    public Subscription(List<ServiceSetting> serviceSettings) {
        super();
        for (ServiceSetting set : serviceSettings) {
            this.addSetting(new SubscriptionSetting(set));
        }
    }

    public BillingModel getBillingModel() {
        return billingModel;
    }

    public Long getSpeed() {
        return this.speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    public void setBillingModel(BillingModel billingModel) {
        this.billingModel = billingModel;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @XmlAttribute
    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    @XmlAttribute
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate.withTime(23, 59, 59, 999);
        this.synchronizeExpiratioDates();
    }

    public Date getExpiresAsDate() {
        return (this.expirationDate == null ? null : this.getExpirationDate().toDate());
    }

    public void setExpiresAsDate(Date exp) {
        this.setExpirationDate(new DateTime(exp));
    }


    public DateTime getLastStatusChangeDate() {
        return lastStatusChangeDate;
    }

    public void setLastStatusChangeDate(DateTime dt) {
        this.lastStatusChangeDate = dt;
    }

    public Date getLastStatusChangeAsDate() {
        return (lastStatusChangeDate == null ? null : getLastStatusChangeDate().toDate());
    }

    public void setLastStatusChangeAsDate(Date exp) {
        this.setLastStatusChangeDate(new DateTime(exp));
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public DateTime getBilledUpToDate() {
        return billedUpToDate;
    }

    public void setBilledUpToDate(DateTime billedUpToDate) {
        this.billedUpToDate = billedUpToDate.withTime(23, 59, 59, 999);
    }

    public Date getBilledUpToDateAsDate() {
        return (billedUpToDate == null ? null : this.getBilledUpToDate().toDate());
    }

    public void setBilledUpToDateAsDate(Date dt) {
        this.setBilledUpToDate(new DateTime(dt));
    }

    public void synchronizeExpiratioDates() {
        if (this.type == SubscriptionType.STATIC) {
            for (SubscriptionResource res : this.getResources()) {
                res.setExpirationDate(new DateTime(this.expirationDate));
            }
        }
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        this.type = type;
    }

    public List<SubscriptionResource> getResources() {
        return resources;
    }

    public void setResources(List<SubscriptionResource> resources) {
        this.resources = resources;
    }

    public void addResource(SubscriptionResource res) {
        this.resources.add(res);
    }

    public void removeResource(SubscriptionResource res) {
        this.resources.remove(res);
    }

    public DateTime getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(DateTime lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public Date getLastPaymentDateAsDate() {
        return (lastPaymentDate != null ? getLastPaymentDate().toDate() : null);
    }

    public List<CampaignRegister> getCampaignRegisters() {
        return campaignRegisters;
    }

    public void setCampaignRegisters(List<CampaignRegister> campaignRegisters) {
        this.campaignRegisters = campaignRegisters;
    }

    public SubscriptionRuntimeDetails getRuntimeDetails() {
        return runtimeDetails;
    }

    public void setRuntimeDetails(SubscriptionRuntimeDetails runtimeDetails) {
        this.runtimeDetails = runtimeDetails;
    }

    public boolean isRestoredFromFinal() {
        return restoredFromFinal;
    }

    public void setRestoredFromFinal(boolean restoredFromFinal) {
        this.restoredFromFinal = restoredFromFinal;
    }

    public DateTime getRestorationDate() {
        return restorationDate;
    }

    public void setRestorationDate(DateTime restorationDate) {
        this.restorationDate = restorationDate;
    }

    public boolean isDiscountEnabled() {
        return isDiscountEnabled;
    }

    public void setDiscountEnabled(boolean isDiscountEnabled) {
        this.isDiscountEnabled = isDiscountEnabled;
    }

    public boolean isTaxFreeEnabled() {
        return isTaxFreeEnabled;
    }

    public void setTaxFreeEnabled(boolean taxFreeEnabled) {
        this.isTaxFreeEnabled = taxFreeEnabled;
    }

    public boolean isIptvOwner() {
        return isIptvOwner;
    }

    public void setIptvOwner(boolean iptvOwner) {
        this.isIptvOwner = iptvOwner;
    }

    public long getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(long discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Long rerate(Long rate) {
        if (rate == null) {
            return null;
        }
        Long newrate;
        if (isDiscountEnabled && discountPercentage > 0 && discountPercentage < 100) {
            newrate = rate * (100L - discountPercentage) / 100L;
        } else if (isTaxFreeEnabled && discountPercentage > 0 && discountPercentage < 100) {
            newrate = rate * (100L) / (100L + discountPercentage);
        } else {
            newrate = rate;
        }
        newrate = (newrate + 500) / 1000 * 1000;
        return newrate;
    }

    public void setLastPaymentDateAsDate(Date dt) {
        if (dt != null)
            setLastPaymentDate(new DateTime(dt));
    }

    public List<SubscriptionVAS> getVasList() {
        if (vasList == null)
            vasList = new ArrayList<>();
        return vasList;
    }

    public List<SubscriptionVAS> getVasList(ValueAddedServiceType type) {
        if (vasList == null || vasList.isEmpty())
            return null;

        List<SubscriptionVAS> subList = new ArrayList<>();

        for (SubscriptionVAS vas : vasList) {
            if (vas.getVas().getCode().getType() == type) {
                subList.add(vas);
            }
        }

        return subList;
    }

    public List<SubscriptionVAS> getVasList(long vasID) {
        if (vasList == null || vasList.isEmpty())
            return null;

        List<SubscriptionVAS> subList = new ArrayList<>();

        for (SubscriptionVAS vas : vasList) {
            if (vas.getVas().getId() == vasID) {
                subList.add(vas);
            }
        }

        return subList;
    }

    public void addVAS(SubscriptionVAS vas) {
        getVasList().add(vas);
    }

    public void setVasList(List<SubscriptionVAS> vasList) {
        this.vasList = vasList;
    }

    public List<SubscriptionSetting> getSettings() {
        return settings;
    }

    public void setSettings(List<SubscriptionSetting> settings) {
        this.settings = settings;
    }

    public void addSetting(SubscriptionSetting setting) {
        this.settings.add(setting);
    }

    public SubscriptionSetting getSettingByType(ServiceSettingType type) {
        for (SubscriptionSetting set : settings) {
            if (set.getProperties().getType() == type) {
                return set;
            }
        }
        return null;
    }

    public String getIP(String IP) {

        for (SubscriptionVAS vas : vasList) {
            SubscriptionResource res = vas.getResource();
            if (res != null) {
                SubscriptionResourceBucket bucket = res.getBucketByType(ResourceBucketType.INTERNET_IP_ADDRESS);
                if (bucket != null) {
                    if (bucket.getCapacity().toLowerCase().contains(IP.toLowerCase())) {
                        return bucket.getCapacity();
                    }
                }
            }
        }
        return "Removed or not exists";
    }

    public String findRadiusUserName(Subscription sbn) {
        try {
            for (SubscriptionSetting setting : sbn.getSettings()) {
                if (setting.getProperties().getType() == ServiceSettingType.USERNAME)
                    return setting.getValue();
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<CampaignRegister> getActiveCampaigns() {
        if (campaignRegisters == null || campaignRegisters.isEmpty()) {
            return null;
        }
        if (activeCampaigns != null) {
            return activeCampaigns;
        }
        activeCampaigns = new ArrayList<>();
        for (final CampaignRegister register : campaignRegisters) {
            if (!register.getStatus().equals(CampaignStatus.PROCESSED)) {
                activeCampaigns.add(register);
            }
        }
        return activeCampaigns;
    }

    public String getActiveCampaignsStr() {
        if (campaignRegisters == null || campaignRegisters.isEmpty()) {
            activeCampaignsStr = "N/A";
            return activeCampaignsStr;
        }
        if (activeCampaignsStr != null) {
            return activeCampaignsStr;
        }
        activeCampaignsStr = "";
        for (final CampaignRegister register : campaignRegisters) {
            if (!register.getStatus().equals(CampaignStatus.PROCESSED)) {
                if (activeCampaignsStr.length() > 0) {
                    activeCampaignsStr += ", ";
                }
                activeCampaignsStr += (register.getCampaign().getName() + ": " + register.getLifeCycleCount());
            }
        }
        if (activeCampaignsStr.isEmpty()) {
            activeCampaignsStr = "N/A";
        }
        return activeCampaignsStr;
    }

    public void copySettingsFromService(List<ServiceSetting> serviceSettings) {
        for (ServiceSetting set : serviceSettings) {
            this.addSetting(new SubscriptionSetting(set));
        }
    }

    public DateTime getExpirationDateWithGracePeriod() {
        return expirationDateWithGracePeriod;
    }

    public void setExpirationDateWithGracePeriod(DateTime expirationDateWithGracePeriod) {
        this.expirationDateWithGracePeriod = expirationDateWithGracePeriod;
    }

    public Date getExpirationDateWithGracePeriodAsDate() {
        return (expirationDateWithGracePeriod != null) ? getExpirationDateWithGracePeriod().toDate() : null;
    }

    public void setExpirationDateWithGracePeriodAsDate(Date expirationDateWithGracePeriod) {
        setExpirationDateWithGracePeriod(new DateTime(expirationDateWithGracePeriod));
    }

    public DateTime getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(DateTime activationDate) {
        this.activationDate = activationDate;
    }

    public Date getActivationDateAsDate() {
        return (activationDate != null ? getActivationDate().toDate() : null);
    }

    public void setActivationDateAsDate(Date activationDate) {
        setActivationDate(new DateTime(activationDate));
    }

    public SubscriptionDetails getDetails() {
        return details;
    }

    public void setDetails(SubscriptionDetails details) {
        this.details = details;
    }

    public boolean isDetailsIdentToSubscriber() {
        return isDetailsIdentToSubscriber;
    }

    public void setDetailsIdentToSubscriber(boolean isDetailsIdentToSubscriber) {
        this.isDetailsIdentToSubscriber = isDetailsIdentToSubscriber;
    }

    public boolean setSettingByType(ServiceSettingType serviceSettingType, String value) {
        if (this.settings == null || settings.isEmpty()) {
            return false;
        }

        for (SubscriptionSetting setting : this.getSettings()) {
            if (setting.getProperties().getType() == serviceSettingType) {
                setting.setValue(value);
                return true;
            }
        }

        return false;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public TechnicalStatus getTechnicalStatus() {
        if (technicalStatus == null)
            technicalStatus = new TechnicalStatus();

        return technicalStatus;
    }

    public void setTechnicalStatus(TechnicalStatus technicalStatus) {
        this.technicalStatus = technicalStatus;
    }

    public List<NotificationSetting> getNotificationSettings() {
        return notificationSettings;
    }

    public void setNotificationSettings(List<NotificationSetting> notificationSettings) {
        this.notificationSettings = notificationSettings;
    }

    public void addNotification(NotificationSetting setting) {
        if (notificationSettings == null)
            notificationSettings = new ArrayList<>();

        notificationSettings.add(setting);
    }

    public NotificationSetting getNotificationSettingByEvent(BillingEvent event) {
        if (notificationSettings == null || notificationSettings.isEmpty())
            return null;

        for (NotificationSetting set : notificationSettings) {
            if (event == set.getEvent())
                return set;
        }

        return null;
    }

    public void removeNotificationSetting(BillingEvent event) {
        if (event == null)
            throw new IllegalArgumentException("Event is required");

        NotificationSetting set = getNotificationSettingByEvent(event);

        if (set != null)
            while (notificationSettings.remove(set)){}
    }

    public void updateNotificationSetting(NotificationSetting setting) {
        removeNotificationSetting(setting.getEvent());
        notificationSettings.add(setting);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Map<Long, Long> getDefaultVasCharges() {
        if (defaultVasCharges == null)
            defaultVasCharges = new HashMap<>();
        return defaultVasCharges;
    }

    public void setDefaultVasCharges(Map<Long, Long> defaultVasCharges) {
        this.defaultVasCharges = defaultVasCharges;
    }

    public void addDefaultVasCharge(Long vasID, Long rate) {
        getDefaultVasCharges().put(vasID, rate);
    }

    public SubscriptionVAS getVASByServiceId(long vasID) {
        DateTime soon = DateTime.now().minusYears(99);
        SubscriptionVAS sbnVas = null;
        if (vasList != null && !vasList.isEmpty()) {
            for (SubscriptionVAS vas : vasList) {
                if (vas.getVas().getId() == vasID && vas.getLastUpdateDate().isAfter(soon)) {
                    soon = vas.getLastUpdateDate();
                    sbnVas = vas;
                }
            }
        }
        return sbnVas;
    }

    public SubscriptionVAS getVASById(long vasID) {
        if (vasList != null && !vasList.isEmpty()) {
            for (SubscriptionVAS vas : vasList) {
                if (vas.getId() == vasID)
                    return vas;
            }
        }
        return null;
    }

    public int countVASById(long vasID) {
        List<SubscriptionVAS> vasList = getVasList(vasID);

        return vasList != null ? vasList.size() : 0;
    }

    public SubscriptionVAS getLastVASByServiceID(long serviceID) {
        if (vasList == null || vasList.isEmpty())
            return null;

        SubscriptionVAS vas = null;

        for (int i = vasList.size() - 1; i >= 0; i--) {
            vas = vasList.get(i);

            if (vas.getVas().getId() == serviceID)
                return vas;
        }

        return null;
    }

    public long getInstallationFee() {
        return installationFee;
    }

    public void setInstallationFee(long installationFee) {

        this.installationFee = installationFee;
    }

    public double getInstallationFeeInDouble() {
        double val = this.installationFee / 100000D;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return Double.parseDouble(decimalFormat.format(val));
    }

    public void setInstallationFeeInDouble(double installFee) {
        this.installationFee = Double.valueOf(installFee * 100000).longValue();
    }

    public DateTime getLastBilledDate() {
        return lastBilledDate;
    }

    public void setLastBilledDate(DateTime lastBilledDate) {
        this.lastBilledDate = lastBilledDate;
    }

    public long calculateTotalCharge() {
        long total = getService().getServicePrice();

        if (getVasList() != null && !getVasList().isEmpty()) {
            long vasPrice = 0;

            //long userID = userFacade.findByUserName("system").getId();

            for (SubscriptionVAS vas : getVasList()) {
                if (vas.getVas().getCode().getType() == ValueAddedServiceType.PERIODIC_STATIC) {
                    vasPrice = vas.getVas().getPrice();

                    if (vas.getStatus() == SubscriptionStatus.FINAL)
                        continue;
                    total += vasPrice * vas.getCount();
                }
            }
        }

        return total;
    }

    public long calculateTotalChargeForPostpaid() {
        long total = serviceFeeRate;

        if (service.getServiceType() == ServiceType.BROADBAND) {
            total *= Long.valueOf(sgetBucketCapacityByType(ResourceBucketType.INTERNET_DOWN) == null ? "0" : sgetBucketCapacityByType(ResourceBucketType.INTERNET_DOWN));
        }

        if (getVasList() != null && !getVasList().isEmpty()) {
            //long userID = userFacade.findByUserName("system").getId();
            for (SubscriptionVAS vas : getVasList()) {
                if (vas.getVas().getCode().getType() == ValueAddedServiceType.PERIODIC_STATIC_VARIABLE_CHARGE
                        && vas.getStatus() != SubscriptionStatus.FINAL) {
                    total += vas.getServiceFeeRate() * vas.getCount();
                }
            }
        }

        return total;
    }

    public String getTotalChargeForView() {
        double interm = calculateTotalChargeForPostpaid() / 100000d;
        //return Long.valueOf(interm).doubleValue();
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);
        return String.format("%.2f", interm);
    }

    public SubscriptionResource getActiveResource() {
        if (!resources.isEmpty()) {
            if (resources.size() == 1)
                return resources.get(0);

            DateTime expDate = null;
            DateTime activeDate = null;
            for (SubscriptionResource res : resources) {
                activeDate = res.getActivationDate();
                expDate = res.getExpirationDate();

                if (activeDate != null && (activeDate.isBeforeNow() || activeDate.equals(DateTime.now()))
                        && expDate != null && expDate.isAfterNow()) {
                    return res;
                }
            }
        }

        return null;
    }

    public void setBucketCapacityByType(ResourceBucketType type, String value) {
        if (!resources.isEmpty()) {
            for (SubscriptionResource res : resources) {
                if (res.getBucketList() != null && !res.getBucketList().isEmpty()) {
                    SubscriptionResourceBucket bucket = res.getBucketByType(type);
                    if (bucket != null) {
                        bucket.setCapacity(value);
                        return;
                    }
                }
            }
        }
    }

    public String sgetBucketCapacityByType(ResourceBucketType type) {
        if (!resources.isEmpty()) {
            for (SubscriptionResource res : resources) {
                if (res.getBucketList() != null && !res.getBucketList().isEmpty()) {
                    SubscriptionResourceBucket bucket = res.getBucketByType(type);
                    if (bucket != null) {
                        return bucket.getCapacity();
                    }
                }
            }
        }

        return null;
    }

    public long     getServiceFeeRate() {
        return serviceFeeRate;
    }

    public void setServiceFeeRateWoTax(long serviceFee) {
        this.serviceFeeRate = (long) ((serviceFee)*100000);
    }
    public void setServiceFeeRate(long serviceFee) {
        this.serviceFeeRate = (long) ((serviceFee*1.18)*100000);
    }
    public void setServiceFeeRateonChange(long serviceFee) {
        this.serviceFeeRate = serviceFee;
    }
    //temporary
    public void setServiceFeeRateforMigration(double serviceFee) {
        this.serviceFeeRate = (long) (serviceFee*100000);
    }

    public String getServiceFeeRateForView() {
        double interm = serviceFeeRate / 100000d;
        //return Long.valueOf(interm).doubleValue();
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);
        return String.format("%.2f", interm);
    }

    public void setServiceFeeRateForView(String price) {

        this.serviceFeeRate = Double.valueOf(Double.parseDouble(price) * 100000.0D).longValue();
    }
    public String getSbnVASAsText() {
        if (this.getVasList() == null || this.vasList.size() == 0)
            return "None";
        StringBuilder sb = new StringBuilder();
        for (SubscriptionVAS sbnVAS : this.getVasList()) {
            sb.append(sbnVAS.getVas().getName()).append("("+sbnVAS.getCount()+")").append(", ");
        }
        return sb.substring(0,sb.length()-2);
    }


    public String getBalanceAsText() {
        return balance.getRealBalanceForView() + " / " + balance.getPromoBalanceForView();
    }

    public boolean hasCredit() {
        boolean hass = false;
        for (SubscriptionVAS vas : getVasList()) {
            if (vas.getVas().isCredit()) {
                hass = true;
            }
        }
        return hass;
    }

    public SubscriptionResourceBucket getResourceBucketByType(ResourceBucketType type) {
        if (resources != null && !resources.isEmpty()) {
            for (SubscriptionResource resource : resources) {
                if (resource.getBucketList() != null && !resource.getBucketList().isEmpty()) {
                    for (SubscriptionResourceBucket bucket : resource.getBucketList()) {
                        if (bucket.getType() == type) {
                            return bucket;
                        }
                    }
                }
            }
        }

        return null;
    }

    public void initializeExpirationDates() {
        this.expirationDate = null;
        this.expirationDateWithGracePeriod = null;
        this.lastPaymentDate = null;
        this.lastStatusChangeDate = null;
    }

    public PaymentTypes getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypes paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Subscription{");
        sb.append(super.toString());
        sb.append(", service=").append(service);
        sb.append(", serviceFeeRate=").append(serviceFeeRate);
        sb.append(", expirationDate=").append((expirationDate != null ? expirationDate.toString(DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss")) : null));
        sb.append(", expirationDateWithGracePeriod=").append((expirationDateWithGracePeriod != null ? expirationDateWithGracePeriod.toString(DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss")) : null));
        sb.append(", createdOn=").append((creationDate != null ? new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(creationDate) : null));
        sb.append(", activatedOn=").append((activationDate != null ? activationDate.toString(DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss")) : null));
        sb.append(", billedUpToDate=").append((billedUpToDate != null ? billedUpToDate.toString(DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss")) : null));
        sb.append(", lastPayed=").append(lastPaymentDate != null ? lastPaymentDate : null);
        sb.append(", balance=").append(balance);
        sb.append(", agreement=").append(agreement);
        sb.append(", identifier=").append(identifier);
        sb.append(", subscriber=").append(subscriber.getId());
        sb.append(", status=").append(status);
        sb.append(", technicalStatus=").append(technicalStatus);
        sb.append(", resources=").append(resources);
        sb.append(", settings=").append(settings);
        sb.append(", details=").append(details);
        sb.append('}');
        return sb.toString();
    }


}