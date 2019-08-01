package com.efe.ms.inventoryservice.domain;

import java.io.Serializable;

import javax.persistence.Transient;

@SuppressWarnings("serial")
public class BusinessEntity implements Serializable,Cloneable {

	protected String id;
	
	@Transient
	protected String keyword;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
