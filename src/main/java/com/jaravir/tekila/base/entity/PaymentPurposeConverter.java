/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.base.entity;

import com.jaravir.tekila.module.accounting.PaymentPurpose;
import com.jaravir.tekila.module.subscription.persistence.entity.SubscriptionStatus;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

import java.math.BigDecimal;

/**
 *
 * @author sajabrayilov
 */
public class PaymentPurposeConverter implements Converter{

    @Override
    public Object convertObjectValueToDataValue(Object objectValue, Session session) {
        return (objectValue == null) ? null : ((PaymentPurpose) objectValue).getCode();
    }

    @Override
    public Object convertDataValueToObjectValue(Object dataValue, Session session) {
        return (dataValue == null) ? null : PaymentPurpose.convertFromCode(((String) dataValue));
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public void initialize(DatabaseMapping mapping, Session session) {
    }    
}
