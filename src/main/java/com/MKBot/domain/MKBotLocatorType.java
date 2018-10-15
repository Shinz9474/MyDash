package com.MKBot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MKBotLocatorType {


	private Integer locatorTypeID;
	private String typeName;
	private String createdBy;
	private String modifiedBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private String createdDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private String modifiedDate;

	public Integer getLocatorTypeID() {
		return locatorTypeID;
	}

	public void setLocatorTypeID(Integer locatorTypeID) {
		this.locatorTypeID = locatorTypeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	};

	
}
