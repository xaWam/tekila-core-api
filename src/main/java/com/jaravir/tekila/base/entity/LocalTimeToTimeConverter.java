package com.jaravir.tekila.base.entity;

import java.sql.Types;

import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.DirectCollectionMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;
import org.joda.time.LocalTime;

public class LocalTimeToTimeConverter implements Converter{

	private static final long serialVersionUID = 2965959080125698080L;

        @Override
	public Object convertObjectValueToDataValue(Object objectValue,
			Session session) {
		//new LocalTime().toDateTimeToday().to
		return objectValue == null ? null : new java.sql.Time(((LocalTime) objectValue).getMillisOfDay());		
	}

	@Override
	public Object convertDataValueToObjectValue(Object dataValue,
			Session session) {
		return dataValue == null ? null : new LocalTime((java.sql.Time)dataValue);		
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initialize(DatabaseMapping mapping, Session session) {
		
		DatabaseField f;
		if (mapping instanceof DirectCollectionMapping)
			f = ((DirectCollectionMapping) mapping).getDirectField();
		else {
			f = mapping.getField();
		}
		f.setSqlType(Types.TIME);
		f.setTypeName("java.sql.Time");
	}
}
