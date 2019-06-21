/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.base.entity;

import com.jaravir.tekila.base.auth.UserStatus;
import com.jaravir.tekila.module.accounting.InvoiceState;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

import java.math.BigDecimal;

/**
 *
 * @author sajabrayilov
 */
public class UserStatusConverter //implements Converter
 {

//    @Override
//    public Object convertObjectValueToDataValue(Object objectValue, Session session) {
//        return (objectValue != null) ? ((UserStatus) objectValue).getStatus() : null;
//    }
//
//    @Override
//    public Object convertDataValueToObjectValue(Object dataValue, Session session) {
//        return (dataValue != null) ? UserStatus.convertFromStatus(((BigDecimal) dataValue).intValue()) : null;
//    }
//
//    @Override
//    public boolean isMutable() {
//        return false;
//    }
//
//    @Override
//    public void initialize(DatabaseMapping mapping, Session session) {
//    }
}
