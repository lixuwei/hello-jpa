package com.lee.study.hellojpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.collect.Lists;

/**
 * 角色
 * @author lee
 *
 */
@Entity
@Table(name="t_role")
public class Role extends IdEntity{


	private static final long serialVersionUID = 5272005272310177984L;

	@Column(nullable=false,length=32)
	private String name;
	
	@ElementCollection
	@CollectionTable(
			name="t_permission",
			joinColumns={
					@JoinColumn(name="roleId")
			}
	)
	@Column(name="permission")
	private List<String> permissionList = Lists.newArrayList();
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL)
	private List<UserRole> userRoles = new ArrayList<UserRole>(0);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<String> permissionList) {
		this.permissionList = permissionList;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	
}
