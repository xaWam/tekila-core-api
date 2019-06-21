package com.jaravir.tekila.module.subscription.persistence.entity;

public enum SubscriberType {
	INDV("Individual"),
	CORP("Corporate");

	private final String typeName;

	SubscriberType(final String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}
}