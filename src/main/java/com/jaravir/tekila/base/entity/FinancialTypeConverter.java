/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.base.entity;

import com.jaravir.tekila.module.accounting.AccountingTransactionType;
import com.jaravir.tekila.module.accounting.FinancialType;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

/**
 *
 * @author sajabrayilov
 */
public class FinancialTypeConverter implements Converter{

    @Override
    public Object convertObjectValueToDataValue(Object objectValue, Session session) {
        return (objectValue != null) ? ((FinancialType) objectValue).getCode() : null;
    }

    @Override
    public Object convertDataValueToObjectValue(Object dataValue, Session session) {
        return (dataValue != null) ? FinancialType.convertFromCode((String) dataValue) : null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public void initialize(DatabaseMapping mapping, Session session) {
    }    
}
