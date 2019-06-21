package com.jaravir.tekila.module.service.entity;

import com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.event.BillingEvent;
import com.jaravir.tekila.module.service.*;
import com.jaravir.tekila.module.subscription.persistence.entity.SubscriptionStatus;
import com.jaravir.tekila.module.subscription.persistence.entity.transition.StatusChangeRule;
import com.jaravir.tekila.module.service.model.BillingModel;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Entity implementation class for Entity: Service
 */
@XmlRootElement
@XmlType(namespace = XmlSchemaNamespace.SERVICE_NS)
public class Service extends BaseEntity implements Serializable {

    private String name;
    private String alternateName; //for Citynet eCare users

    private long servicePrice;
    private ServiceType serviceType;
    private List<Resource> resourceList;
    private boolean isBillByLifeCycle;
    private long installFee;
    private String dsc;
    private ServiceProvider provider;
    private List<ValueAddedService> vasList;
    private List<ValueAddedService> defaultVasList;
    private List<ServiceSetting> settings;
    private List<ValueAddedService> vasSettings;
    private ServiceGroup group;
    private List<NotificationSetting> notificationSettings;
    private boolean isAllowEquipment;
    private boolean isAllowStock;
    private List<ValueAddedService> allowedVASList;
    private List<StatusChangeRule> statusChangeRules;
    private BillingModel billingModel;
    private List<ServiceProfile> serviceProfileList;
    private boolean isAvailableOnEcare;
    private boolean isActive = true;
    private ServiceSubgroup subgroup;
    private boolean isEligibleForServiceChange; //ecare service change
    private boolean isIptvBundled;
    private List<ServiceProperty> properties;

    /*	@Temporal(TemporalType.TIMESTAMP)
                private LocalDateTime lastUpdateDate;
                */
    private static final long serialVersionUID = 1L;

    public Service() {
        this.serviceProfileList = new CopyOnWriteArrayList<ServiceProfile>();
        this.resourceList = new CopyOnWriteArrayList<Resource>();
        this.settings = new ArrayList<ServiceSetting>();
        statusChangeRules = new ArrayList<>();
    }

    public Service(String name, long price,
                   ServiceType serviceType, boolean isBillByLifeCycle) {
        this();
        this.name = name;
        this.servicePrice = price;
        this.serviceType = serviceType;
        this.isBillByLifeCycle = isBillByLifeCycle;
    }

    public ServiceSubgroup getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(ServiceSubgroup subgroup) {
        this.subgroup = subgroup;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<ServiceProfile> getServiceProfileList() {
        return serviceProfileList;
    }

    public void setServiceProfileList(List<ServiceProfile> serviceProfileList) {
        this.serviceProfileList = serviceProfileList;
    }

    public String getName() {
        return this.name;
    }

	/* (non-Javadoc)
     * @see com.jaravir.tekila.module.service.entity.Service#setName(java.lang.String)
	 */

    public void setName(String name) {
        this.name = name;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    /* (non-Javadoc)
     * @see com.jaravir.tekila.module.service.entity.Service#getRateProfile()
     */
    public long getInstallationFee() {
        return installFee;
    }

    public void setInstallationFee(long fee) {
        installFee = fee;
    }


	/* (non-Javadoc)
     * @see com.jaravir.tekila.module.service.entity.Service#setRateProfile(com.jaravir.tekila.module.service.entity.RateProfile)
	 */


	/* (non-Javadoc)
     * @see com.jaravir.tekila.module.service.entity.Service#getServiceType()
	 */

    public ServiceType getServiceType() {
        return this.serviceType;
    }

	/* (non-Javadoc)
     * @see com.jaravir.tekila.module.service.entity.Service#setServiceType(com.jaravir.tekila.module.service.ServiceType)
	 */

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    /* (non-Javadoc)
     * @see com.jaravir.tekila.module.service.entity.Service#getIsBillByLifeCycle()
     */
    @XmlAttribute
    public boolean getIsBillByLifeCycle() {
        return this.isBillByLifeCycle;
    }

	/* (non-Javadoc)
	 * @see com.jaravir.tekila.module.service.entity.Service#setIsBillByLifeCycle(boolean)
	 */

    public void setIsBillByLifeCycle(boolean isBillByLifeCycle) {
        this.isBillByLifeCycle = isBillByLifeCycle;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = new CopyOnWriteArrayList<Resource>(resourceList);
    }

    public void addResource(Resource res) {
        this.resourceList.add(res);
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }


    public Resource getActiveResource() {
        Iterator<Resource> it = this.resourceList.iterator();
        Resource res = null;

        while (it.hasNext()) {
            res = it.next();

            if (res.isExpired())
                continue;

            //check if resource is active
            if (res.isActive()) {
                return res;
            }
        }

        return null;
    }

    public long getServicePrice() {
        return servicePrice;
    }
    public String getServicePriceForView() {
        double interm = servicePrice / 100000d;
        //return Long.valueOf(interm).doubleValue();
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.FLOOR);
        return String.format("%.2f", interm);
    }
    public void setServicePrice(long servicePrice) {
        this.servicePrice = servicePrice;
    }


    public long getInstallFee() {
        return installFee;
    }

    public void setInstallFee(long installFee) {
        this.installFee = installFee;
    }

    public boolean removeResource(Resource res) {
        return resourceList.remove(res);
    }

    public boolean removeAllResources(List<Resource> resList) {
        return resourceList.removeAll(resList);
    }

    public boolean addAllResources(List<Resource> resList) {
        return this.resourceList.addAll(resList);
    }

    /*
    public LocalDateTime getLastUpdateDate() {
    return this.lastUpdateDate;
    }
    private void setLastUpdateDate() {
    this.lastUpdateDate = LocalDateTime.now();
    }
     */
    public List<ServiceSetting> getSettings() {
        return settings;
    }

    public void setSettings(List<ServiceSetting> settings) {
        this.settings = settings;
    }

    public void addSetting(ServiceSetting setting) {
        settings.add(setting);
    }

    public ServiceSetting getSettingByType(ServiceSettingType type) {
        for (ServiceSetting set : settings) {
            if (set.getType() == type) {
                return set;
            }
        }
        return null;
    }

    public List<ValueAddedService> getVasList() {
        return vasList;
    }

    public void setVasList(List<ValueAddedService> vasList) {
        this.vasList = vasList;
    }

    public List<ValueAddedService> getVasSettings() {
        return vasSettings;
    }

    public void setVasSettings(List<ValueAddedService> vasSettings) {
        this.vasSettings = vasSettings;
    }

    public ServiceGroup getGroup() {
        return group;
    }

    public void setGroup(ServiceGroup group) {
        this.group = group;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }


    public boolean isAllowEquipment() {
        return isAllowEquipment;
    }

    public void setAllowEquipment(boolean isAllowEquipment) {
        this.isAllowEquipment = isAllowEquipment;
    }

    public boolean isAllowStock() {
        return isAllowStock;
    }

    public void setAllowStock(boolean isAllowStock) {
        this.isAllowStock = isAllowStock;
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
            notificationSettings.remove(set);
    }

    public void updateNotificationSetting(NotificationSetting setting) {
        removeNotificationSetting(setting.getEvent());
        notificationSettings.add(setting);
    }

    public List<ValueAddedService> getDefaultVasList() {
        if (defaultVasList == null)
            defaultVasList = new ArrayList<>();
        return defaultVasList;
    }

    public void setDefaultVasList(List<ValueAddedService> defaultVasList) {
        this.defaultVasList = defaultVasList;
    }

    public void addDefaultVAS(ValueAddedService defaultVAS) {
        getDefaultVasList().add(defaultVAS);
    }

    public ValueAddedService getDefaultVasById(Long vasID) {
        if (!defaultVasList.isEmpty() && vasID != null) {
            for (ValueAddedService ds : defaultVasList) {
                if (ds.getId() == vasID)
                    return ds;
            }
        }
        return null;
    }

    public ValueAddedService getDefaultVasByType(ValueAddedServiceType type) {
        if (!defaultVasList.isEmpty() && type != null) {
            for (ValueAddedService ds : defaultVasList) {
                if (ds.getCode().getType() == type)
                    return ds;
            }
        }
        return null;
    }

    public List<ValueAddedService> getAllowedVASList() {
        if (allowedVASList == null) {
            allowedVASList = new ArrayList<>();
        }
        return allowedVASList;
    }

    public void setAllowedVASList(List<ValueAddedService> allowedVASList) {
        this.allowedVASList = allowedVASList;
    }

    public boolean addAllowedVAS(ValueAddedService vas) {
        if (getAllowedVASList().isEmpty() || !getAllowedVASList().contains(vas)) {
            return getAllowedVASList().add(vas);
        }
        return false;
    }

    public boolean removeAllowedVas(ValueAddedService vas) {
        if (!getAllowedVASList().isEmpty() && getAllowedVASList().contains(vas)) {
            return getAllowedVASList().remove(vas);
        }

        return false;
    }

    public List<StatusChangeRule> getStatusChangeRules() {
        return statusChangeRules;
    }

    public void setStatusChangeRules(List<StatusChangeRule> statusChangeRules) {
        this.statusChangeRules = statusChangeRules;
    }

    public boolean addRule(SubscriptionStatus initStatus, SubscriptionStatus finalStatus, ValueAddedService vas) {
        StatusChangeRule rule = new StatusChangeRule(initStatus, finalStatus, vas);
        return addRule(rule);
    }

    public boolean addRule(StatusChangeRule rule) {
        if (statusChangeRules.contains(rule))
            return false;

        statusChangeRules.add(rule);
        return true;
    }

    public StatusChangeRule findRule(SubscriptionStatus initStatus, SubscriptionStatus finalStatus) {
        if (statusChangeRules.isEmpty())
            return null;

        int ind = statusChangeRules.indexOf(new StatusChangeRule(initStatus, finalStatus));

        return ind >= 0 ? statusChangeRules.get(ind) : null;
    }

    public boolean removeRule(StatusChangeRule rule) {
        return statusChangeRules.remove(rule);
    }


    public BillingModel getBillingModel() {
        return billingModel;
    }

    public void setBillingModel(BillingModel billingModel) {
        this.billingModel = billingModel;
    }

    public boolean isAvailableOnEcare() {
        return isAvailableOnEcare;
    }

    public void setAvailableOnEcare(boolean availableOnEcare) {
        isAvailableOnEcare = availableOnEcare;
    }

    public boolean isEligibleForServiceChange() {
        return isEligibleForServiceChange;
    }

    public void setEligibleForServiceChange(boolean eligibleForServiceChange) {
        isEligibleForServiceChange = eligibleForServiceChange;
    }

    public boolean isIptvBundled() {
        return isIptvBundled;
    }

    public void setIptvBundled(boolean iptvBundled) {
        isIptvBundled = iptvBundled;
    }

    public List<ServiceProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<ServiceProperty> properties) {
        this.properties = properties;
    }

    public ResourceBucket getResourceBucketByType(ResourceBucketType type) {
        if (resourceList != null && !resourceList.isEmpty()) {
            for (Resource resource : resourceList) {
                if (resource.getBucketList() != null && !resource.getBucketList().isEmpty()) {
                    for (ResourceBucket bucket : resource.getBucketList()) {
                        if (bucket.getType() == type) {
                            return bucket;
                        }
                    }
                }
            }
        }

        return null;
    }

    public void addServiceProfile(ServiceProfile serviceProfile) {
        this.serviceProfileList.add(serviceProfile);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Service{");
        sb.append(super.toString());
        sb.append(", name=").append(name);
        sb.append(", installationFee=").append(installFee);
        sb.append(", servicePrice=").append(servicePrice);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", resourceList=").append(resourceList);
        sb.append(", isBillByLifeCycle").append(isBillByLifeCycle);
        sb.append(", provider=").append(provider);
        sb.append(", settings=").append(settings);
        sb.append(", vasSettings=").append(vasSettings);
        sb.append(", defaultVasList=").append(defaultVasList);
        sb.append(", group=").append(group);
        sb.append(",billingModel=").append(billingModel);
        sb.append(", dsc=").append(dsc);
        sb.append('}');
        return sb.toString();
    }

    public double getServicePriceInDouble() {
        double val = this.servicePrice / 100000D;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return Double.parseDouble(decimalFormat.format(val));
    }

    public void setServicePriceInDouble(double price) {
        this.servicePrice = Double.valueOf(price*100000).longValue();
    }
    public double getInstallFeeInDouble() {
        double val = this.installFee / 100000D;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return Double.parseDouble(decimalFormat.format(val));
    }

    public void setInstallFeeInDouble(double fee) {
        this.installFee = Double.valueOf(fee*100000).longValue();
    }
}
