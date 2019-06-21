package com.jaravir.tekila.base.entity;

import com.jaravir.tekila.module.store.status.StoreItemStatus;
import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.DirectCollectionMapping;
import org.eclipse.persistence.mappings.DirectMapMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

import java.math.BigDecimal;
import java.sql.Types;

/**
 * Created by sajabrayilov on 13.03.2015.
 */
public class StoreItemStatusConverter implements Converter {
    @Override
    public Object convertObjectValueToDataValue(Object objectValue, Session session) {
        return (objectValue != null) ? ((StoreItemStatus) objectValue).getCode() : null;
    }

    @Override
    public Object convertDataValueToObjectValue(Object dataValue, Session session) {
        return (dataValue != null) ? StoreItemStatus.getFromCode((Integer) dataValue) : null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public void initialize(DatabaseMapping mapping, Session session) {
        DatabaseField field = null;

        if (mapping instanceof DirectCollectionMapping) {
            field = ((DirectCollectionMapping) mapping).getDirectField();
        }
        else {
            field = mapping.getField();
        }

        field.setSqlType(Types.INTEGER);
        field.setTypeName("java.lang.Integer");
    }
}
