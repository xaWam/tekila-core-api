package com.jaravir.tekila.base.entity;

import java.sql.Timestamp;
import java.util.Calendar;

import java.util.Date;
import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.DirectCollectionMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;


public class TestDateConverter implements Converter{
	
	private static final long serialVersionUID = -3168228110650149245L;

	@Override
	public Object convertObjectValueToDataValue(Object objectValue,
			Session session) {
		return objectValue == null ? null : 
			new java.sql.Date(((DateTime) objectValue).getMillis());
			//new Timestamp(((DateTime) objectValue).getMillis());
			//DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss.SSSSSSSSS").print((DateTime) objectValue);
	}

	@Override
	public Object convertDataValueToObjectValue(Object dataValue,
			Session session) {		
		return dataValue == null ? null : 
			//new DateTime((Calendar) dataValue);
			//new DateTime((Timestamp) dataValue);
			//DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss.SSSSSSSSS").parseDateTime((String)dataValue);
			//new DateTime(Timestamp.valueOf((String)dataValue));			
                       // new DateTime((Date) dataValue);
                        new DateTime (((java.sql.Date) dataValue));
	}

	@Override
	public boolean isMutable() {
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
		f.setSqlType(java.sql.Types.DATE);
		f.setTypeName("java.sql.Date");
	}
}
