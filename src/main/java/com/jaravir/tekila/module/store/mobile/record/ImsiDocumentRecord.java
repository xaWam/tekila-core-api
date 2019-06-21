package com.jaravir.tekila.module.store.mobile.record;

import com.jaravir.tekila.module.store.mobile.Imsi;
import com.jaravir.tekila.module.store.mobile.MobileCategory;

/**
 * Created by sajabrayilov on 13.03.2015.
 */
public class ImsiDocumentRecord {
    private String iccid;
    private String identififer;
    private Integer category;
    private Long provider;

    public ImsiDocumentRecord () {}

    public ImsiDocumentRecord(String iccid, String identififer, Integer category) {
        this.iccid = iccid;
        this.identififer = identififer;
        this.category = category;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getIdentififer() {
        return identififer;
    }

    public void setIdentififer(String identififer) {
        this.identififer = identififer;
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

    public Imsi getImsi () {
        Imsi imsi = new Imsi();

        if (iccid != null)
            imsi.setIccid(iccid);

        if (identififer != null)
            imsi.setIdentifier(identififer);

        if (category != null)
            imsi.setCategory(MobileCategory.getFromPosition(category));

        return imsi;
    }
}
