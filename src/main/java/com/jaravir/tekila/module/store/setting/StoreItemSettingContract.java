package com.jaravir.tekila.module.store.setting;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * Created by sajabrayilov on 02.04.2015.
 */
public interface StoreItemSettingContract<T> {
   T getValue();
   void setValue(T value);
}
