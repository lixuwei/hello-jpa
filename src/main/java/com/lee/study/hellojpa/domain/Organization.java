package com.lee.study.hellojpa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

@Entity
@Table(name="t_organization")
public class Organization extends IdEntity {

	private static final long serialVersionUID = 7654102672122490273L;
	
	@Column(nullable=false,length=64)
	private String name;
	
	@Column(length=255)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="parentId")
	private Organization parent;
	
	@OneToMany(cascade=CascadeType.REFRESH,mappedBy="parent")
	private List<Organization> children = Lists.newArrayList();

	@OneToMany(cascade=CascadeType.REFRESH,mappedBy="organization")
	private List<User> users = Lists.newArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
	}

	public List<Organization> getChildren() {
		return children;
	}

	public void setChildren(List<Organization> children) {
		this.children = children;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.addValue(id)
				.addValue(name)
				.addValue(parent == null ? null:parent.getName())
				.addValue(children.size())
				.toString();
	}
}
