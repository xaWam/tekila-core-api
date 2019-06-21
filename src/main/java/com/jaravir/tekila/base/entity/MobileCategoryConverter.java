package com.jaravir.tekila.base.entity;

import com.jaravir.tekila.module.store.mobile.MobileCategory;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

/**
 * Created by sajabrayilov on 13.03.2015.
 */
public class MobileCategoryConverter implements Converter {
    @Override
    public Object convertObjectValueToDataValue(Object objectValue, Session session) {
        return (objectValue != null) ? ((MobileCategory) objectValue).getCode() : null;
    }

    @Override
    public Object convertDataValueToObjectValue(Object dataValue, Session session) {
        return (dataValue != null) ? MobileCategory.getFromCode((String) dataValue) : null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public void initialize(DatabaseMapping mapping, Session session) {

    }
}
