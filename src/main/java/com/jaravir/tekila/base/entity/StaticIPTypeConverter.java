package com.jaravir.tekila.base.entity;

import com.jaravir.tekila.module.store.ip.StaticIPType;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

import java.math.BigDecimal;

/**
 * Created by shnovruzov on 10/26/2016.
 */
public class StaticIPTypeConverter implements Converter {
    @Override
    public Object convertObjectValueToDataValue(Object objectValue, Session session) {
        return (objectValue == null) ? null : ((StaticIPType) objectValue).getCode();
    }

    @Override
    public Object convertDataValueToObjectValue(Object dataValue, Session session) {
        return (dataValue == null) ? null : StaticIPType.convertFromCode(((BigDecimal) dataValue).intValue());
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public void initialize(DatabaseMapping mapping, Session session) {
    }
}
