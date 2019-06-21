package com.jaravir.tekila.base.auth.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = -7208162895135199624L;
	private UserRole role;
	private String userName;
	private String userPass;
	private String fullName;
	private OrganizationalUnit unit;
	private List<UserPermission> permList;
	
	public User(String userName, String fullName, OrganizationalUnit unit) {
		this.userName = userName;
		this.fullName = fullName;
		this.unit = unit;
	}
	
	public void setPassword (String pass) {
		this.userPass = pass;
	}
	
	public String getPassword() {
		return this.userPass;
	}
	
	public void addPermission(UserPermission perm) {
		this.permList.add(perm);
	}
	
	public List<UserPermission> getPermissionsList() {
		return this.permList;
	}
	
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public OrganizationalUnit getUnit() {
		return unit;
	}

	public void setUnit(OrganizationalUnit unit) {
		this.unit = unit;
	}
	
	
}
