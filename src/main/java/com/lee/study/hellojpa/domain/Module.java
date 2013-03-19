package com.lee.study.hellojpa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

@Entity
@Table(name="t_module")
public class Module extends IdEntity implements Comparable<Module>{

	private static final long serialVersionUID = 8886670119432123091L;

	
	@Column(nullable=false,length=255)
	private String name;
	
	@Column(nullable=false,length=255)
	private String url;
	
	@Column(nullable=false,length=32)
	private String sn;
	
	@Column(length=2)
	private Integer priority = 99;
	
	@ManyToOne
	@JoinColumn(name="parentId")
	private Module parent;
	
	@OneToMany(cascade=CascadeType.REFRESH,mappedBy="parent")
	@OrderBy("priority ASC")
	private List<Module> children = Lists.newArrayList();
	
	public int compareTo(Module module) {
		
		if(module == null){
			return -1;
		} else if (module == this){
			return 0;
		} else if (this.priority < module.getPriority()){
			return -1;
		} else if (this.priority > module.getPriority()){
			return 1;
		}
		
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Module getParent() {
		return parent;
	}

	public void setParent(Module parent) {
		this.parent = parent;
	}

	public List<Module> getChildren() {
		return children;
	}

	public void setChildren(List<Module> children) {
		this.children = children;
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
