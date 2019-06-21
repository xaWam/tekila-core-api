/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.base.entity;

import com.jaravir.tekila.module.periodic.JobCategory;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

import static com.jaravir.tekila.module.periodic.JobCategory.convertFromCode;

/**
 *
 * @author sajabrayilov
 */
public class JobCategoryConverter implements Converter{

    @Override
    public Object convertObjectValueToDataValue(Object objectValue, Session session) {
        return (objectValue == null) ? null : ((JobCategory) objectValue).getCode();
    }

    @Override
    public Object convertDataValueToObjectValue(Object dataValue, Session session) {
        return (dataValue == null) ? null : convertFromCode((String) dataValue);
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public void initialize(DatabaseMapping mapping, Session session) {
    }    
}