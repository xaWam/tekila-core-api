package com.jaravir.tekila.base.auth.persistence;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.auth.Privilege;
import com.jaravir.tekila.base.auth.persistence.exception.NoPrivilegeFoundException;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.jsonview.JsonViews;
import com.jaravir.tekila.module.service.entity.ServiceProvider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class Group extends BaseEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 5806611861592960991L;
	private String groupName;
	private List<Role> roles;
	@JsonView(JsonViews.Group.class)
	private List<User> userList;
	private String email;
	private String dsc;

	public Group() {
		this.userList = new ArrayList<User>();
	}

	public Group(String name) {
		this();
		this.groupName = name;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void addUser(User user) {
		this.userList.add(user);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> role) {
		this.roles = role;
	}

	public void addRole (Role role) {
		if (roles == null)
			roles = new ArrayList<>();

		roles.add(role);
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public boolean hasPrivilige (String subModule, Privilege privilege) throws NoPrivilegeFoundException {
		if (subModule == null)
			throw new IllegalArgumentException("Submodule is required");
		for (Role role : roles) {
			try {
				if (role.hasPrivilege(subModule, privilege))
					return true;
			}
			catch (NoPrivilegeFoundException ex) {

			}
		}
		throw new NoPrivilegeFoundException();
	}

	public boolean hasPriviligeForMobule (String module, Privilege privilege) throws NoPrivilegeFoundException {
		if (module == null)
			throw new IllegalArgumentException("Module is required");

		for (Role role : roles) {
			try {
				if (role.hasPrivilegeForModule(module, privilege))
					return true;
			}
			catch (NoPrivilegeFoundException ex) {

			}
		}

		throw new NoPrivilegeFoundException();
	}

	public String getRolesForView() {
		if (getRoles() == null || getRoles().isEmpty())
			return null;

		StringBuilder sb = new StringBuilder();

		for (Role role : roles) {
			sb.append(role.getName()).append(", ");
		}

		return sb.delete(sb.lastIndexOf(","), sb.length()).toString();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Group{");
		sb.append(super.toString());
		sb.append(", groupName='").append(groupName).append('\'');
		sb.append(", role=").append(roles);
		sb.append(", userList=").append(userList);
		sb.append(", email=").append(email);
		sb.append(", desc=").append(dsc);
		sb.append('}');
		return sb.toString();
	}
}
