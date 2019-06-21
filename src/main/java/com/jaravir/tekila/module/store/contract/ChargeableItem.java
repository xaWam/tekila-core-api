package com.jaravir.tekila.module.store.contract;

import com.jaravir.tekila.module.store.setting.PriceSetting;

/**
 * Created by sajabrayilov on 03.04.2015.
 */
public interface ChargeableItem {
    Long getPrice ();
    void setPrice(Long price);
}
