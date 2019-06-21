package com.jaravir.tekila.base.entity;

import com.jaravir.tekila.module.store.scratchcard.Settings.ScratchCardSettingType;
import com.jaravir.tekila.module.subscription.persistence.entity.SubscriptionType;

import java.math.BigDecimal;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

/**
 * Created by shnovruzov on 5/5/2016.
 */
public class ScratchCardSettingTypeConverter implements Converter {

    @Override
    public Object convertObjectValueToDataValue(Object objectValue, Session session) {
        return (objectValue == null) ? null : ((ScratchCardSettingType) objectValue).TYPE;
    }

    @Override
    public Object convertDataValueToObjectValue(Object dataValue, Session session) {
        return (dataValue == null) ? null : ScratchCardSettingType.convertFromCode(((BigDecimal) dataValue).intValue());
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public void initialize(DatabaseMapping mapping, Session session) {
    }
}
