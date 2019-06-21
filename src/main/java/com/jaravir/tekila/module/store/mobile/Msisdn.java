package com.jaravir.tekila.module.store.mobile;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.base.entity.Util;
import com.jaravir.tekila.module.service.entity.ServiceProvider;
import com.jaravir.tekila.module.store.contract.ChargeableItem;
import com.jaravir.tekila.module.store.setting.PriceSetting;
import com.jaravir.tekila.module.store.status.StoreItemStatus;

/**
 * Created by sajabrayilov on 13.03.2015.
 */
public class Msisdn extends BaseEntity implements ChargeableItem {
    private final static String ITEM_NAME = "MSISDN";
    private String value;
    private StoreItemStatus status;
    private MobileCategory category;
    private CommercialCategory commercialCategory;
    private User user;
    private ServiceProvider provider;
    private PriceSetting priceSetting;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StoreItemStatus getStatus() {
        return status;
    }

    public void setStatus(StoreItemStatus status) {
        this.status = status;
    }

    public MobileCategory getCategory() {
        return category;
    }

    public void setCategory(MobileCategory category) {
        this.category = category;
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

    public CommercialCategory getCommercialCategory() {
        return commercialCategory;
    }

    public void setCommercialCategory(CommercialCategory commercialCategory) {
        this.commercialCategory = commercialCategory;
    }

    public Long getPrice() {
        return priceSetting != null ? priceSetting.getValue() : null;
    }

    public void setPrice(Long price) {
        if (priceSetting == null)
            priceSetting = new PriceSetting();

        priceSetting.setValue(price);
    }

    public PriceSetting getPriceSetting() {
        return priceSetting;
    }

    public String getPriceForView() {
        if (priceSetting != null && priceSetting.getValue() != null)
            return Util.convertFromLongToString(priceSetting.getValue());

        return null;
    }

    public void removePriceSetting () {
        if (priceSetting != null) {
            this.priceSetting = null;
        }
    }

    public static String getItemName() {
        return ITEM_NAME;
    }
}
