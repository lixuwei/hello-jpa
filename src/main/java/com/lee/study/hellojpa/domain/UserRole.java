package com.lee.study.hellojpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 用户角色关联表
 * @author lee
 *
 */
@Entity
@Table(name="t_user_role")
public class UserRole extends IdEntity{

	private static final long serialVersionUID = -5921230548100993632L;

	@Column(length=2,nullable=false)
	private Integer priority = 99;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="roleId")
	private Role role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
