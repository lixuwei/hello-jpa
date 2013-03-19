package com.lee.study.hellojpa.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.google.common.collect.Sets;

@Entity
@Table(name="t_user")
public class User extends IdEntity{

	private static final long serialVersionUID = -1057715676093916222L;

	@Column(nullable=false,length=32,unique=true,updatable=false)
	private String realname;
	
	@Column(nullable=false,length=16,unique=true,updatable=false)
	private String username;
	
	@Column(nullable=false,length=64)
	private String password;
	
	@Transient
	private String plainPassword;
	
	@Column(nullable=false,length=32)
	private String salt;
	
	@Column(length=32)
	private String phone;
	
	@Column(length=128)
	private String email;
	
	/**
	 * 账号创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date creatTime;
	
	/**
	 * 使用状态
	 */
	@Column(nullable=false,length=16)
	private String status = "enabled";
	
	/**
	 * mappedBy 在关联类中的字段
	 */
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	@OrderBy("priority ASC")
	private Set<UserRole> userRoles  = Sets.newHashSet(); 

	@ManyToOne
	@JoinColumn(name="orgId")
	private Organization organization;

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
}







































