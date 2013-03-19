package com.lee.study.hellojpa.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 这个类是为了统一注解的类型和生成策略
 * @author lee
 *
 */
@MappedSuperclass
public class IdEntity implements Serializable{

	private static final long serialVersionUID = 7606445353129862668L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
