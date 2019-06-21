package com.jaravir.tekila.base.entity;

import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.DirectCollectionMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

import com.jaravir.tekila.module.accounting.entity.TransactionType;

public class TransactionTypeConverter implements Converter{
	
	private static final long serialVersionUID = -2548403932847577783L;

	@Override
	public Object convertObjectValueToDataValue(Object objectValue,
			Session session) {
		return objectValue == null ? null : ((TransactionType) objectValue).toString();
	}

	@Override
	public Object convertDataValueToObjectValue(Object dataValue,
			Session session) {
		
		return dataValue == null ? null : TransactionType.valueOf((String)dataValue);
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initialize(DatabaseMapping mapping, Session session) {
		final DatabaseField field;
		
		if (mapping instanceof DirectCollectionMapping)
			field = ((DirectCollectionMapping) mapping).getDirectField();
		else {
			field = mapping.getField();
		}
		
		field.setSqlType(java.sql.Types.VARCHAR);
		field.setTypeName("java.lang.String");
	}

}
