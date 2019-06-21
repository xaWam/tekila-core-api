package com.jaravir.tekila.module.store.mobile.record;

import com.jaravir.tekila.base.entity.Util;
import com.jaravir.tekila.module.accounting.entity.TaxationCategory;
import com.jaravir.tekila.module.store.mobile.MobileCategory;
import com.jaravir.tekila.module.store.mobile.Msisdn;

/**
 * Created by sajabrayilov on 13.03.2015.
 */
public class MsisdnDocumentRecord {
    private String value;
    private Integer category;
    private Long provider;
    private Long commercialCategory;
    private Double price;

    public MsisdnDocumentRecord () {

    }

    public MsisdnDocumentRecord(String value, Integer category) {
        this.value = value;
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Long getProvider() {
        return provider;
    }

    public void setProvider(Long provider) {
        this.provider = provider;
    }

    public Long getCommercialCategory() {
        return commercialCategory;
    }

    public void setCommercialCategory(Long commercialCategory) {
        this.commercialCategory = commercialCategory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Msisdn getMsisdn() {
        Msisdn msisdn = new Msisdn();

        if (value != null)
            msisdn.setValue(value);

        if (category != null)
            msisdn.setCategory(MobileCategory.getFromPosition(category));

        if (price != null) {
            Long am = Util.convertFromDoubleToLong(price);
            msisdn.setPrice(am);
        }
        return msisdn;
    }
}
