package com.jaravir.tekila.base.auth.entity;

public class OrganizationalUnit {
	private String unitName;
	private String unitCode;
	
	public OrganizationalUnit(String unitName, String unitCode) {
		this.unitName = unitName;
		this.unitCode = unitCode;
	}
	
	public String getUnitName() {
		return unitName;
	}
	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public String getUnitCode() {
		return unitCode;
	}
	
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}	
}
