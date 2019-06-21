package com.jaravir.tekila.module.store.setting;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * Created by sajabrayilov on 02.04.2015.
 */
public class PriceSetting extends BaseEntity implements StoreItemSettingContract<Long>{
    private Long value;

    public PriceSetting() {}

    public PriceSetting(Long value) {
        this.value = value;
    }

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public void setValue(Long value) {
       this.value = value;
    }
}
